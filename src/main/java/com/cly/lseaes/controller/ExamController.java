package com.cly.lseaes.controller;


import com.cly.lseaes.entity.Exam;
import com.cly.lseaes.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cly
 * @since 2023-04-10
 */
@RestController
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    private IExamService examService;

    @PostMapping("/create")
    public String create(@RequestBody Exam exam) {
        examService.save(exam);
        return "ok";
    }


}
