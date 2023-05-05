package com.cly.lseaes.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cly.lseaes.entity.QuestionAnswer;
import com.cly.lseaes.service.IQuestionAnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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

    @GetMapping("/list/{quId}")
    public List<QuestionAnswer> getAnsByQuid(@PathVariable Integer quId) {
        QueryWrapper<QuestionAnswer> wrapper = new QueryWrapper<>();
        wrapper.eq("question_id", quId);
        return iQuestionAnswerService.list(wrapper);
    }

    @PostMapping("/save")
    public String createQuestionAnswer(@RequestBody List<QuestionAnswer> questionAnswer) {
        iQuestionAnswerService.saveOrUpdateBatch(questionAnswer);
        return "ok";
    }

    @PostMapping("/delete/{id}")
    public String deleteQuestionAnswer(@PathVariable Integer id) {
        iQuestionAnswerService.removeById(id);
        return "ok";
    }



}
