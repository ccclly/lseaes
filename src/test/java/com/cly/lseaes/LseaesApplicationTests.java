package com.cly.lseaes;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cly.lseaes.dto.UserExamDTO;
import com.cly.lseaes.entity.*;
import com.cly.lseaes.mapper.*;
import com.cly.lseaes.service.*;
import com.cly.lseaes.utils.JwtUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
class LseaesApplicationTests {

    @Autowired
    private IUserService userService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private INoticeService noticeService;
    @Autowired
    private ICourseService iCourseService;
    @Autowired
    private IProblemService problemService;
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private ProblemMapper problemMapper;
    @Autowired
    private IUserExamService userExamService;
    @Autowired
    private UserExamMapper userExamMapper;
    @Autowired
    private IExamService examService;
    @Autowired
    private ExamMapper examMapper;
    @Autowired
    private IQuestionService questionService;
    @Autowired
    private IRecodeLessonService recodeLessonService;
    @Autowired
    private IPaperService paperService;

    @Test
    void userTest() {
//        List<User> list = userService.list();
//        list.forEach(System.out::println);
//        List<Map<String, Object>> resultList = userMapper.selectUserExamById(1);

//        List<UserExamDTO> list = new ArrayList<>();
//        for (Map<String, Object> map: resultList){
//            UserExamDTO userExamDTO = new UserExamDTO();
//            userExamDTO.setId((Integer) map.get("id"));
//            userExamDTO.setName((String) map.get("name"));
//            userExamDTO.setGrade((String) map.get("grade"));
//            userExamDTO.setCollege((String) map.get("college"));
//            userExamDTO.setMajor((String) map.get("major"));
//            userExamDTO.setSelected((Long) map.get("selected"));
//            list.add(userExamDTO);
//        }
//        System.out.println(list);;
//        UserExam userExam = new UserExam();
//        userExam.setUserId(2);
//        userExam.setExamId(1);
//        userExamService.deleteUerExam(userExam);
//        System.out.println(examService.list());
        System.out.println(paperService.countScore(7));

    }
    @Test
    void userTest1() {

        List<Notice> list = noticeService.list();
        list.forEach(System.out::println);
    }

    @Test
    void t() {
        UserExam userExam = new UserExam();
        userExam.setUserId(1);
        userExam.setExamId(1);
        userExam.setScore(78.0);
                QueryWrapper<UserExam> wrapper = new QueryWrapper<>();
        wrapper.eq("exam_id", userExam.getExamId())
                .eq("user_id", userExam.getUserId());
        userExamMapper.update(userExam, wrapper);
    }

    @Test
    void userTest2() {
        User user = new User();
        user.setName("forTest3");
        user.setPassword("12321");
        userMapper.insert(user);
    }

    @Test
    void userTest3() {
        List<User> list = userMapper.selectList(null);
        list.stream().sorted((u1, u2) -> u2.getCreateAt().compareTo(u1.getCreateAt())).limit(4).forEach(System.out::println);
    }


    @Test
    void courseTest() {
//        Course course = new Course();
//        course.setId(1);
//        course.setName("生物实验室安全777");
//        course.setDescription("《生物实验室安全》是涉及生物学研究相关专业的实验室安全知识。本课程通过大量视频资料和案例分析，系统地介绍了生物实验室的安全隐患、安全防范措施以及事故发生时的应急处理措施，旨在提高实验人员的安全防范意识和应急处理能力，有效防范安全事故发生、降低安全事故危害。课程内容主要包括实验室基础安全知识、生物安全、微生物实验安全防控、分子生物学安全防控、化学品安全、废弃物安全等。");
//        iCourseService.saveOrUpdate(course);
        List<Map<String, Object>> resultList = courseMapper.selectCourseDetailsById(2);
        System.out.println(resultList);
    }

    @Test
    void proTest() {
//        List<Problem> list = problemService.list();
//        list.forEach(System.out::println);
//        System.out.println(problemMapper.getRAND(10));
        List<Map<String, Object>> resultList = problemMapper.selectProblemUserById(1);
        System.out.println(resultList);
    }

    @Test
    void examTest(){
        List<Exam> list = examService.list();
        System.out.println(list);
    }
}
