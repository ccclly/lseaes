package com.cly.lseaes.controller;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cly.lseaes.entity.Question;
import com.cly.lseaes.entity.QuestionAnswer;
import com.cly.lseaes.service.IQuestionAnswerService;
import com.cly.lseaes.service.IQuestionService;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * <p>
 * 试题主表 前端控制器
 * </p>
 *
 * @author cly
 * @since 2023-04-30
 */
@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private IQuestionService iQuestionService;
    @Autowired
    private IQuestionAnswerService questionAnswerService;

    // Create (增) endpoint
    @PostMapping("/save")
    public String createQuestion(@RequestBody Question question) {
        // implementation code here// Save or update question
        iQuestionService.saveOrUpdate(question);
        return "ok";
    }

    // Delete (删) endpoint
    @PostMapping("/delete/{id}")
    public String deleteQuestion(@PathVariable Integer id) {
        // implementation code here// Delete question by id
        iQuestionService.removeById(id);
        return "ok";
    }

    // Retrieve (查) endpoint
    @GetMapping("/{id}")
    public Question getQuestion(@PathVariable Integer id) {
        // implementation code here// Get question by id
        return iQuestionService.getById(id);
    }


    // Retrieve all (查) endpoint
    @GetMapping("/list")
    public List<Question> getAllQuestions() {
        // implementation code here// Get all questions
        return iQuestionService.list();
    }

    @GetMapping("/{id}/question-answer")
    public HashMap<String, Object> getQuestionAnswersByQuestionId(@PathVariable Integer id) {
        HashMap<String, Object> result = new HashMap<>();
        
        result.put("question", JSON.toJSON(iQuestionService.getById(id)));
        result.put("ans", JSON.toJSON(questionAnswerService.list(new QueryWrapper<QuestionAnswer>().eq("question_id", id))));
        return result;
    }



}
