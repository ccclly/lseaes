package com.cly.lseaes.controller;


import com.cly.lseaes.entity.Notice;
import com.cly.lseaes.service.INoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.util.HtmlUtils;

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
@RequestMapping("/notice")
public class NoticeController {
    private final INoticeService noticeService;

    public NoticeController(INoticeService noticeService) {
        this.noticeService = noticeService;
    }

    @GetMapping("/list")
    public List<Notice> getNoticeList() {
        
        return noticeService.list();
    }

    @GetMapping("/{id}")
    public Notice getNoticeById(@PathVariable("id") Integer id) {
        return noticeService.getById(id);
    }

    @PostMapping("/save")
    public String saveNotice(@RequestBody Notice notice) {
        noticeService.saveOrUpdate(notice);
        return "ok";
    }

}
