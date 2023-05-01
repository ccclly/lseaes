package com.cly.lseaes.controller;


import com.cly.lseaes.entity.QuestionRepository;
import com.cly.lseaes.service.IQuestionRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 试题题库关联 前端控制器
 * </p>
 *
 * @author cly
 * @since 2023-04-30
 */
@RestController
@RequestMapping("/question-repository")
public class QuestionRepositoryController {
    @Autowired
    private IQuestionRepositoryService iQuestionRepositoryService;

    @PostMapping("/save")
    public String save(@RequestBody QuestionRepository questionRepository) {
        iQuestionRepositoryService.saveOrUpdate(questionRepository);
        return "ok";
    }
}
