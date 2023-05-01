package com.cly.lseaes.controller;


import com.cly.lseaes.entity.Exam;
import com.cly.lseaes.service.IExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cly
 * @since 2023-04-24
 */
@RestController
@RequestMapping("/exam")
public class ExamController {
    @Autowired
    private IExamService iExamService;

    @GetMapping("/list")
    public List<Exam> list() {
        return iExamService.list();
    }

    @PostMapping("/save")
    public List<Exam> save(@RequestBody Exam exam){
        iExamService.save(exam);
        return iExamService.list();
    }

    @GetMapping("/e/{id}")
    public List<Exam> getUserExam(@PathVariable Integer id){
        return iExamService.selectExamByUserId(id);
    }
}
