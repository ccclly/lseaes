package com.cly.lseaes.controller;


import com.cly.lseaes.dto.RecordDTO;
import com.cly.lseaes.entity.RecodeLesson;
import com.cly.lseaes.entity.User;
import com.cly.lseaes.service.IRecodeLessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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
    public Integer getByIds(@RequestBody RecodeLesson recodeLesson, HttpServletRequest httpServletRequest) {
        User user = (User) httpServletRequest.getAttribute("id");
        return iRecodeLessonService.getProcessForLesson(recodeLesson.getCourseId(), user.getId(), recodeLesson.getLessonId());
    }
    @PostMapping("/course")
    public Integer getForCourse(@RequestBody RecodeLesson recodeLesson, HttpServletRequest httpServletRequest) {
        User user = (User) httpServletRequest.getAttribute("id");
        return iRecodeLessonService.getProcessForCourse(recodeLesson.getCourseId(), user.getId());
    }

    @GetMapping("/record_list")
    public List<RecordDTO> getProcessList(HttpServletRequest httpServletRequest) {
        User user = (User) httpServletRequest.getAttribute("id");
        return iRecodeLessonService.getProcessList(user.getId());
    }



}
