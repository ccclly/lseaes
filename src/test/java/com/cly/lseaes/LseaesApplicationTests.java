package com.cly.lseaes;

import com.cly.lseaes.entity.Course;
import com.cly.lseaes.entity.Notice;
import com.cly.lseaes.entity.User;
import com.cly.lseaes.mapper.UserMapper;
import com.cly.lseaes.service.ICourseService;
import com.cly.lseaes.service.INoticeService;
import com.cly.lseaes.service.IUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

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

    @Test
    void userTest() {
        List<User> list = userService.list();
        list.forEach(System.out::println);
    }
    @Test
    void userTest1() {

        List<Notice> list = noticeService.list();
        list.forEach(System.out::println);
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
        Course course = new Course();
        course.setId(1);
        course.setName("生物实验室安全777");
        course.setDescription("《生物实验室安全》是涉及生物学研究相关专业的实验室安全知识。本课程通过大量视频资料和案例分析，系统地介绍了生物实验室的安全隐患、安全防范措施以及事故发生时的应急处理措施，旨在提高实验人员的安全防范意识和应急处理能力，有效防范安全事故发生、降低安全事故危害。课程内容主要包括实验室基础安全知识、生物安全、微生物实验安全防控、分子生物学安全防控、化学品安全、废弃物安全等。");
        iCourseService.saveOrUpdate(course);
    }
}
