package com.cly.lseaes.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cly.lseaes.entity.*;
import com.cly.lseaes.mapper.PaperMapper;
import com.cly.lseaes.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author cly
 * @since 2023-04-30
 */
@Service
public class PaperServiceImpl extends ServiceImpl<PaperMapper, Paper> implements IPaperService {
    @Autowired
    private PaperMapper mapper;
    @Autowired
    private IExamService examService;
    @Autowired
    private IQuestionService questionService;
    @Autowired
    private IQuestionAnswerService questionAnswerService;
    @Autowired
    private IPaperQuestionService paperQuestionService;
    @Autowired
    private IPaperQuestionAnswerService paperQuestionAnswerService;
    @Autowired
    private IUserExamService userExamService;

    private static List<String> ABC = Arrays.asList(new String[]{
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X"
            , "Y", "Z"
    });

    @Override
    public HashMap<String, Object> acreatePaper(Integer userId, Integer examId) {
        System.out.println(examId);
        QueryWrapper<Paper> wrapper = new QueryWrapper<>();
        wrapper.lambda()
                .eq(Paper::getUserId, userId)
                .eq(Paper::getState, 1)
                .eq(Paper::getIsTest, 0);

        int exists = (int) this.count(wrapper);
        System.out.println(111);
        System.out.println(exists);
        System.out.println(111);
        List<Paper> paperList = this.list(wrapper);
        System.out.println(paperList);
        if (exists > 0) {
            for (Paper paper : paperList) {
                LocalDateTime t = paper.getCreateAt();
                LocalDateTime now = LocalDateTime.now();
                // 计算时间差
                Duration duration = Duration.between(t, now);
                // 判断时间差是否超过考试时间
                boolean isOver30Minutes = duration.toMinutes() > paper.getTotalTime();
                if (isOver30Minutes) {
                    finishPaper(paper.getExamId());
                } else {
                    System.out.println("返回的paperId：");
                    System.out.println(paper.getId());
                    return getPaperById(paper.getId());
                }
            }
        }

        List<PaperQuestion> pqList = this.generateByRepo(examId);

        Paper paper = this.savePaper(userId, examId, pqList, false);


        return getPaperById(paper.getId());
    }

    @Override
    public void finishPaper(Integer paperId) {
        Double score = this.countScore(paperId);
        Paper paper = this.getById(paperId);
        paper.setState(0);
        paper.setUserScore(score);
        if (paper.getIsTest()) {
            this.updateById(paper);
            return;
        }
        UserExam userExam = userExamService.getUserExam(paper.getUserId(), paper.getExamId());
        if (userExam == null) {
            UserExam userExam1 = new UserExam();
            userExam1.setExamId(paper.getExamId());
            userExam1.setUserId(paper.getUserId());
            userExam1.setScore(score);
            userExamService.save(userExam1);
        } else {
            if (userExam.getScore() < score) {
                userExam.setScore(score);
                userExamService.updateScore(userExam);
            }
        }
        this.updateById(paper);
    }

    @Override
    public HashMap<String, Object> getPaperById(Integer paperId) {
        HashMap<String, Object> result = new HashMap<>();
        Paper paper = mapper.selectById(paperId);
        result.put("paper", JSON.toJSON(paper));
        Exam exam = null;
        if (paper.getExamId()!=null) {
            exam = examService.getById(paper.getExamId());
            result.put("exam", JSON.toJSON(exam));
        }
        List<Question> questionList = questionService.selectQuListByPaperId(paperId);
        result.put("quList", JSON.toJSON(questionList));
        List<List<QuestionAnswer>> questionAnswerList = new ArrayList<>();
        List<List<PaperQuestionAnswer>> paperQAList = new ArrayList<>();
        for (Question question : questionList) {
            QueryWrapper<QuestionAnswer> wrapper = new QueryWrapper<>();
            wrapper.eq("question_id", question.getId());
            List<QuestionAnswer> questionAnswers = questionAnswerService.list(wrapper);
            questionAnswerList.add(questionAnswers);

            QueryWrapper<PaperQuestionAnswer> wrapper1 = new QueryWrapper<>();
            wrapper1.eq("paper_id", paperId)
                    .eq("question_id", question.getId());
            List<PaperQuestionAnswer> paperQuestionAnswers = paperQuestionAnswerService.list(wrapper1);
            paperQAList.add(paperQuestionAnswers);
        }
        result.put("quansList", JSON.toJSON(questionAnswerList));
        result.put("paperQAs", JSON.toJSON(paperQAList));
        return result;
    }

    private List<PaperQuestion> generateByRepo(Integer examId) {
        Exam exam = examService.getById(examId);
        List<PaperQuestion> quList = new ArrayList<>();


        int count = exam.getCount(), repo_id = exam.getRepositoryId();
        List<Question> questions = questionService.selectQuListByRepoIdAndCount(repo_id, count);

        for (Question q :
                questions) {
            PaperQuestion paperQuestion = new PaperQuestion();
            paperQuestion.setQuestionId(q.getId());
            paperQuestion.setQuestionType(q.getType());
            quList.add(paperQuestion);
        }

        return quList;
    }

    private Paper savePaper(Integer userId, Integer examId, List<PaperQuestion> pqList, Boolean isTest){
        Paper paper = new Paper();
        Exam exam = null;
        if (examId != null) {
            exam = examService.getById(examId);
            paper.setTotalTime(exam.getTotalTime());
            paper.setName(exam.getName());
        }else
            paper.setName("练习");
        paper.setUserId(userId);
        paper.setExamId(examId);
        paper.setUserScore(0.0);
        paper.setIsTest(isTest);
        mapper.insert(paper);
        this.savePaperQu(paper.getId(), pqList);
        return paper;
    }


    private void savePaperQu(Integer paperId, List<PaperQuestion> quList) {
        List<PaperQuestion> batchQuList = new ArrayList<>();
        List<PaperQuestionAnswer> batchAnswerList = new ArrayList<>();
        int sort = 0;
        for (PaperQuestion paperQuestion : quList) {
            paperQuestion.setPaperId(paperId);
            paperQuestion.setSort(sort);

            List<QuestionAnswer> answerList = questionAnswerService.listAnswerByRandom(paperQuestion.getQuestionId());

            if (!CollectionUtils.isEmpty(answerList)) {

                int ii = 0;
                for (QuestionAnswer answer : answerList) {
                    PaperQuestionAnswer paperQuAnswer = new PaperQuestionAnswer();
                    paperQuAnswer.setPaperId(paperId);
                    paperQuAnswer.setQuestionId(answer.getQuestionId());
                    paperQuAnswer.setAnswerId(answer.getId());
                    paperQuAnswer.setSort(ii);
                    paperQuAnswer.setAbc(ABC.get(ii));
                    paperQuAnswer.setIsRight(answer.getIsRight());
                    ii++;
                    batchAnswerList.add(paperQuAnswer);
                }
            }
            batchQuList.add(paperQuestion);
            sort++;
        }

        paperQuestionService.saveBatch(batchQuList);
        paperQuestionAnswerService.saveBatch(batchAnswerList);
    }

    @Override
    public String fillAns(Integer paperId, Integer questionId, List<Integer> ansId) {
        boolean right = true;
        System.out.println(111);
        System.out.println(paperId);
        System.out.println(questionId);
        System.out.println(ansId);
        QueryWrapper<PaperQuestionAnswer> wrapper = new QueryWrapper<>();
        wrapper.eq("paper_id", paperId)
                .eq("question_id", questionId);
        List<PaperQuestionAnswer> list = paperQuestionAnswerService.list(wrapper);
        System.out.println(list);
        for (PaperQuestionAnswer item : list) {

            if (ansId.contains(item.getAnswerId())) {
                item.setChecked(true);
                paperQuestionAnswerService.updateById(item);
            }else {
                item.setChecked(false);
                paperQuestionAnswerService.updateById(item);
            }
            //有一个对不上就是错的
            if (item.getIsRight()!=null && !item.getIsRight().equals(item.getChecked())) {
                right = false;
            }
        }
        PaperQuestion paperQuestion = new PaperQuestion();
        paperQuestion.setQuestionId(questionId);
        paperQuestion.setPaperId(paperId);
        paperQuestion.setIsRight(right);
        paperQuestion.setAnswered(true);

        paperQuestionService.updateByKey(paperQuestion);

        return "ok";
    }

    @Override
    public Double countScore(Integer paperId) {
        QueryWrapper<PaperQuestion> wrapper = new QueryWrapper<>();
        wrapper.eq("paper_id", paperId);

        List<PaperQuestion> list = paperQuestionService.list(wrapper);
        int rightN = 0;
        for (PaperQuestion p :
                list) {
            if (p.getIsRight()) {
                rightN++;
            }
        }
        return ((double)rightN / (double)list.size());
    }

    @Override
    public HashMap<String, Object> createPaperForTest(Integer num, Integer useId) {
        List<Question> questions = questionService.selectQuListByR(num);
        List<PaperQuestion> quList = new ArrayList<>();
        for (Question q :
                questions) {
            PaperQuestion paperQuestion = new PaperQuestion();
            paperQuestion.setQuestionId(q.getId());
            paperQuestion.setQuestionType(q.getType());
            quList.add(paperQuestion);
        }
        Paper paper = this.savePaper(useId, null, quList, true);

        return getPaperById(paper.getId());
    }
}
