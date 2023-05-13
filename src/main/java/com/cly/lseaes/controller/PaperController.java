package com.cly.lseaes.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cly.lseaes.dto.PaperAnsDTO;
import com.cly.lseaes.entity.Paper;
import com.cly.lseaes.entity.User;
import com.cly.lseaes.entity.UserExam;
import com.cly.lseaes.service.IPaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

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

    @PostMapping("/test/{num}")
    public HashMap<String, Object> createPaperForTest(@PathVariable Integer num, HttpServletRequest httpServletRequest) {
        User user = (User) httpServletRequest.getAttribute("id");
        System.out.println(user);
        return iPaperService.createPaperForTest(num, user.getId());
    }

    // Read endpoint
    @GetMapping("/{id}")
    public Paper getPaperById(@PathVariable("id") Integer id) {
        return iPaperService.getById(id);
    }

    @GetMapping("/de/{id}")
    public HashMap<String, Object> getPaperDeById(@PathVariable Integer id) {
        return iPaperService.getPaperById(id);
    }

    @PostMapping("/fill-answer")
    public String fillAnswer(@RequestBody PaperAnsDTO paperAnsDTO) {
        iPaperService.fillAns(paperAnsDTO.getPaperId(), paperAnsDTO.getQuestionId(), paperAnsDTO.getAnsIds());
        return "ok";
    }

    @GetMapping("/submit/{paperId}")
    public Double submit(@PathVariable Integer paperId) {
        iPaperService.finishPaper(paperId);
        return iPaperService.countScore(paperId);
    }

    @GetMapping("/list")
    public List<Paper> getPapersById(HttpServletRequest httpServletRequest) {
        User user = (User) httpServletRequest.getAttribute("id");
        QueryWrapper<Paper> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id", user.getId());
        List<Paper> list = iPaperService.list(wrapper);
        System.out.println(
                list.get(0).getUserScore()
        );
        return list;
    }
}
