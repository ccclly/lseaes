package com.cly.lseaes.controller;


import com.cly.lseaes.dto.UserExamDTO;
import com.cly.lseaes.entity.UserExam;
import com.cly.lseaes.service.IUserExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cly
 * @since 2023-04-24
 */
@RestController
@RequestMapping("/user-exam")
public class UserExamController {

    @Autowired
    private IUserExamService iUserExamService;

    @PostMapping("/update/{id}")
    public String update(@RequestBody List<UserExamDTO> list, @PathVariable Integer id) {

        for (UserExamDTO item : list){
            UserExam userExam = new UserExam();
            userExam.setExamId(id);
            userExam.setUserId(item.getId());
            if (item.getSelected() == 1){
                iUserExamService.insertUerExam(userExam);
            }else {
                iUserExamService.deleteUerExam(userExam);
            }
        }

        return "ok";
    }
}
