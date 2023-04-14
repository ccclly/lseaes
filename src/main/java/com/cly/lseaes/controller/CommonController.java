package com.cly.lseaes.controller;

//import com.cly.lseaes.entity.Course;
import com.cly.lseaes.entity.Notice;
import com.cly.lseaes.entity.Rule;
//import com.cly.lseaes.entity.User;
//import com.cly.lseaes.service.ICourseService;
import com.cly.lseaes.service.INoticeService;
import com.cly.lseaes.service.IRuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class CommonController {
//
//    private final INoticeService noticeService;
//    private final IRuleService ruleService;
//    private final ICourseService courseService;
//
//    public CommonController(ICourseService courseService, INoticeService noticeService, IRuleService ruleService) {
//        this.courseService = courseService;
//        this.noticeService = noticeService;
//        this.ruleService = ruleService;
//    }
//
//
//    @GetMapping("/index")
//    public Map<String, List<Object>> indexData() {
//        Map<String, List<Object>> resultMap = new HashMap<>();
//        List<Notice> latestNotices = noticeService.list().stream()
//                .sorted((n1, n2) -> n2.getCreateAt().compareTo(n1.getCreateAt()))
//                .limit(4)
//                .collect(Collectors.toList());
//        List<Rule> latestRules = ruleService.list().stream()
//                .sorted((n1, n2) -> n2.getCreateAt().compareTo(n1.getCreateAt()))
//                .limit(4)
//                .collect(Collectors.toList());
//        List<Course> latestCourses = courseService.list().stream()
//                .sorted((n1, n2) -> n2.getCreateAt().compareTo(n1.getCreateAt()))
//                .limit(6)
//                .collect(Collectors.toList());
//
//        resultMap.put("notices", latestNotices.stream().map(n -> (Object) n).collect(Collectors.toList()));
//        resultMap.put("rules", latestRules.stream().map(n -> (Object) n).collect(Collectors.toList()));
//        resultMap.put("courses", latestCourses.stream().map(n -> (Object) n).collect(Collectors.toList()));
//        return resultMap;
//    }
}
