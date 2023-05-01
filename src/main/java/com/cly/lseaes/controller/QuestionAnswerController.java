package com.cly.lseaes.controller;


import com.cly.lseaes.entity.QuestionAnswer;
import com.cly.lseaes.service.IQuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 试题答案选项 前端控制器
 * </p>
 *
 * @author cly
 * @since 2023-04-30
 */
@RestController
@RequestMapping("/question-answer")
public class QuestionAnswerController {
    @Autowired
    private IQuestionAnswerService iQuestionAnswerService;
    @GetMapping("/{id}")
    public QuestionAnswer getQuestionAnswer(@PathVariable Integer id) {
        return iQuestionAnswerService.getById(id);
    }

    @PostMapping("/save")
    public QuestionAnswer createQuestionAnswer(@RequestBody QuestionAnswer questionAnswer) {
        iQuestionAnswerService.saveOrUpdate(questionAnswer);
        return questionAnswer;
    }

    @PostMapping("/delete/{id}")
    public String deleteQuestionAnswer(@PathVariable Long id) {
        iQuestionAnswerService.removeById(id);
        return "ok";
    }



}
