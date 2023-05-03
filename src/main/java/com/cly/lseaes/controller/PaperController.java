package com.cly.lseaes.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cly.lseaes.dto.PaperAnsDTO;
import com.cly.lseaes.entity.Paper;
import com.cly.lseaes.entity.UserExam;
import com.cly.lseaes.service.IPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cly
 * @since 2023-04-30
 */
@RestController
@RequestMapping("/paper")
public class PaperController {
    @Autowired
    private IPaperService iPaperService;


    // Generate CRUD endpoints for Paper entity
// Create endpoint
    @PostMapping("/create")
    public HashMap<String, Object> createPaper(@RequestBody UserExam userExam) {
        return iPaperService.acreatePaper(userExam.getUserId(), userExam.getExamId());
    }

    // Read endpoint
    @GetMapping("/{id}")
    public Paper getPaperById(@PathVariable("id") Integer id) {
        return iPaperService.getById(id);
    }

    @GetMapping("/de/{id}")
    public HashMap<String , Object> getPaperDeById(@PathVariable Integer id){
        return iPaperService.getPaperById(id);
    }

    @PostMapping("/fill-answer")
    public String fillAnswer(@RequestBody PaperAnsDTO paperAnsDTO) {
        iPaperService.fillAns(paperAnsDTO.getPaperId(), paperAnsDTO.getQuestionId(), paperAnsDTO.getAnsIds());
        return "ok";
    }

    @GetMapping("/submit/{paperId}")
    public Double submit(@PathVariable Integer paperId) {
        Paper paper = iPaperService.getById(paperId);
        paper.setState(0);
        paper.setUserScore(iPaperService.countScore(paperId));
        iPaperService.updateById(paper);
        return iPaperService.countScore(paperId);
    }

}
