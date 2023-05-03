package com.cly.lseaes.controller;

//import com.cly.lseaes.entity.Course;
import com.cly.lseaes.dto.CourseDTO;
import com.cly.lseaes.entity.*;
//import com.cly.lseaes.entity.User;
//import com.cly.lseaes.service.ICourseService;
import com.cly.lseaes.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class CommonController {

    private final INoticeService noticeService;
    private final IRuleService ruleService;
    private final ICourseService courseService;
    @Autowired
    private IChapterService chapterService;
    @Autowired
    private ILessonService lessonService;

    public CommonController(ICourseService courseService, INoticeService noticeService, IRuleService ruleService) {
        this.courseService = courseService;
        this.noticeService = noticeService;
        this.ruleService = ruleService;
    }

    @GetMapping("/index")
    public Map<String, List<Object>> indexData() {
        Map<String, List<Object>> resultMap = new HashMap<>();
        List<Notice> latestNotices = noticeService.list().stream()
                .sorted((n1, n2) -> n2.getCreateAt().compareTo(n1.getCreateAt()))
                .limit(4)
                .collect(Collectors.toList());
        List<Rule> latestRules = ruleService.list().stream()
                .sorted((n1, n2) -> n2.getCreateAt().compareTo(n1.getCreateAt()))
                .limit(4)
                .collect(Collectors.toList());
        List<Course> latestCourses = courseService.list().stream()
                .sorted((n1, n2) -> n2.getCreateAt().compareTo(n1.getCreateAt()))
                .limit(6)
                .collect(Collectors.toList());

        resultMap.put("notices", latestNotices.stream().map(n -> (Object) n).collect(Collectors.toList()));
        resultMap.put("rules", latestRules.stream().map(n -> (Object) n).collect(Collectors.toList()));
        resultMap.put("courses", latestCourses.stream().map(n -> (Object) n).collect(Collectors.toList()));
        return resultMap;
    }

    @PostMapping("/course_save")
    public CourseDTO saveCourse(@RequestBody CourseDTO courseDTO) {
        Course course = new Course();
        System.out.println(courseDTO);
        System.out.println(course);
        course.setName(courseDTO.getName());
        course.setDescription(courseDTO.getDescription());
        course.setImgName(courseDTO.getImgName());
        courseService.saveOrUpdate(course);
        System.out.println(course);

        List<Chapter> chapterList = courseDTO.getChapterList();
        List<Lesson> lessonList = courseDTO.getLessonList();

        System.out.println(chapterList);
        chapterList.forEach(item -> {
            item.setCourseId(course.getId());
        });
        chapterService.saveOrUpdateBatch(chapterList);
        System.out.println(chapterList);

        System.out.println(lessonList);
        lessonList.forEach(item -> {
            item.setChapterId(chapterList.get(item.getChapterId()).getId());
            item.setCourseId(course.getId());
        });
        lessonService.saveOrUpdateBatch(lessonList);
        System.out.println(lessonList);

        return courseService.selectCourseDTOById(course.getId());
    }

}
