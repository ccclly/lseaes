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
                .eq(Paper::getState, 1);

        int exists = (int) this.count(wrapper);

        if (exists > 0) {

        }

        List<PaperQuestion> pqList = this.generateByRepo(examId);

        Paper paper = this.savePaper(userId, examId, pqList);


        return getPaperById(paper.getId());
    }


    @Override
    public HashMap<String, Object> getPaperById(Integer paperId) {
        HashMap<String, Object> result = new HashMap<>();
        Paper paper = mapper.selectById(paperId);
        result.put("paper", JSON.toJSON(paper));
        Exam exam = examService.getById(paper.getExamId());
        result.put("exam",  JSON.toJSON(exam));
        List<Question> questionList = questionService.selectQuListByPaperId(paperId);
        result.put("quList", JSON.toJSON(questionList));
        List<List<QuestionAnswer>> questionAnswerList = new ArrayList<>();
        for (Question question : questionList) {
            QueryWrapper<QuestionAnswer> wrapper = new QueryWrapper<>();
            wrapper.eq("question_id", question.getId());
            List<QuestionAnswer> questionAnswers = questionAnswerService.list(wrapper);
            questionAnswerList.add(questionAnswers);
        }
        result.put("quansList", JSON.toJSON(questionAnswerList));
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

    private Paper savePaper(Integer userId, Integer examId, List<PaperQuestion> pqList){
        Paper paper = new Paper();
        Exam exam = examService.getById(examId);
        paper.setUserId(userId);
        paper.setExamId(examId);
        paper.setTotalTime(exam.getTotalTime());
        paper.setUserScore(0);
        paper.setName(exam.getName());
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
}
