package com.cly.lseaes.controller;


import com.cly.lseaes.entity.Problem;
import com.cly.lseaes.service.IProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cly
 * @since 2023-04-18
 */
@RestController
@RequestMapping("/problem")
public class ProblemController {

    @Autowired
    private IProblemService iProblemService;

    @PostMapping("/save")
    public List<Problem> save(@RequestBody Problem problem) {
        iProblemService.saveOrUpdate(problem);
        return iProblemService.list();
    }

    @GetMapping("/list")
    public List<Problem> list() {
        return iProblemService.list();
    }
}