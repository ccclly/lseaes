package com.cly.lseaes.controller;


import com.cly.lseaes.service.IPaperQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cly
 * @since 2023-04-30
 */
@RestController
@RequestMapping("/paper-question")
public class PaperQuestionController {

    @Autowired
    private IPaperQuestionService iPaperQuestionService;



}
