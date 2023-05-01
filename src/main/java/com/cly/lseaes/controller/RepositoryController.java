package com.cly.lseaes.controller;


import com.cly.lseaes.entity.Repository;
import com.cly.lseaes.service.IQuestionService;
import com.cly.lseaes.service.IRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cly
 * @since 2023-04-30
 */
@RestController
@RequestMapping("/repository")
public class RepositoryController {
    @Autowired
    private IRepositoryService iRepositoryService;

    // Generate CRUD APIs for Repository entity
    // Create
    @PostMapping("/save")
    public String createRepository(@RequestBody Repository repository) {
        // implementation code here
        iRepositoryService.saveOrUpdate(repository);
        return "ok";
    }

    // Read
    @GetMapping("/{id}")
    public HashMap<String, Object> readRepository(@PathVariable Integer id) {
        // implementation code here
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("repo", iRepositoryService.getById(id));
        return hashMap;
    }

    // Delete
    @RequestMapping("/delete")
    public void deleteRepository() {
        // implementation code here
    }
    // Read all questions in a specific repository

}
