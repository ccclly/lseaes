package com.cly.lseaes.controller;


import com.cly.lseaes.entity.Rule;
import com.cly.lseaes.service.IRuleService;
//import com.cly.lseaes.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cly
 * @since 2023-04-03
 */
@RestController
@RequestMapping("/rule")
public class RuleController {

    @Autowired
    private IRuleService ruleService;

    @GetMapping("/list")
    public List<Rule> getAllRules() {
        return ruleService.list();
    }

    @GetMapping("/{id}")
    public Rule getRuleById(@PathVariable("id") Integer id) {
        return ruleService.getById(id);
    }

}
