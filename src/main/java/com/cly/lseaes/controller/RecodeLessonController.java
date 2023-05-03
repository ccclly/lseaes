package com.cly.lseaes.controller;


import com.cly.lseaes.entity.RecodeLesson;
import com.cly.lseaes.service.IRecodeLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cly
 * @since 2023-05-01
 */
@RestController
@RequestMapping("/recode-lesson")
public class RecodeLessonController {
    @Autowired
    private IRecodeLessonService iRecodeLessonService;

    @PostMapping("/save")
    public Integer save(@RequestBody RecodeLesson recodeLesson) {
        iRecodeLessonService.saveOrUpdate(recodeLesson);
        return recodeLesson.getId();
    }

    @PostMapping("/r-l")
    public Integer getByIds(@RequestBody RecodeLesson recodeLesson) {
        return iRecodeLessonService.getProcessForLesson(recodeLesson.getCourseId(), recodeLesson.getUserId(), recodeLesson.getLessonId());
    }
    @PostMapping("/course")
    public Integer getForCourse(@RequestBody RecodeLesson recodeLesson) {
        return iRecodeLessonService.getProcessForCourse(recodeLesson.getCourseId(), recodeLesson.getUserId());
    }



}
