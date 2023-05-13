package com.cly.lseaes.controller;


import com.cly.lseaes.entity.Lesson;
import com.cly.lseaes.service.ILessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cly
 * @since 2023-04-15
 */
@RestController
@RequestMapping("/lesson")
public class LessonController {
    @Autowired
    private ILessonService iLessonService;

    @GetMapping("/{id}")
    public Lesson get(@PathVariable Integer id) {
        return iLessonService.getById(id);
    }
}
