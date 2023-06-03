package com.cly.lseaes.controller;


import com.cly.lseaes.dto.EnterDTO;
import com.cly.lseaes.entity.EnterPermit;
import com.cly.lseaes.entity.User;
import com.cly.lseaes.entity.UserExam;
import com.cly.lseaes.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cly
 * @since 2023-05-10
 */
@RestController
@RequestMapping("/enter-permit")
public class EnterPermitController {
    @Autowired
    private IEnterPermitService iEnterPermitService;
    @Autowired
    private IExamService examService;
    @Autowired
    private ICourseService courseService;
    @Autowired
    private IUserExamService userExamService;
    @Autowired
    private IRecodeLessonService recodeLessonService;

    @PostMapping("/save")
    public List<EnterPermit> save(@RequestBody EnterPermit enterPermit) {
        iEnterPermitService.saveOrUpdate(enterPermit);
        return iEnterPermitService.list();
    }

    @PostMapping("/delete/{id}")
    public List<EnterPermit> delete(@PathVariable Integer id) {
        iEnterPermitService.removeById(id);
        return iEnterPermitService.list();
    }

    @GetMapping("/list")
    public List<EnterPermit> get() {
        return iEnterPermitService.list();
    }

    @GetMapping("/list-user")
    public List<EnterDTO> getByUser(HttpServletRequest httpServletRequest) {
        User user = (User) httpServletRequest.getAttribute("id");
        return iEnterPermitService.getByUser(user.getId());
    }
}
