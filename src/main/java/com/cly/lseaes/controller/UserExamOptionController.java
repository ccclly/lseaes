package com.cly.lseaes.controller;


import com.cly.lseaes.entity.Problem;
import com.cly.lseaes.entity.User;
import com.cly.lseaes.entity.UserExam;
import com.cly.lseaes.entity.UserExamOption;
import com.cly.lseaes.service.IProblemService;
import com.cly.lseaes.service.IUserExamOptionService;
import com.cly.lseaes.service.IUserExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cly
 * @since 2023-04-26
 */
@RestController
@RequestMapping("/user-exam-option")
public class UserExamOptionController {

    @Autowired
    private IUserExamOptionService iUserExamOptionService;
    @Autowired
    private IProblemService problemService;
    @Autowired
    private IUserExamService userExamService;

    @PostMapping("/save")
    public String save(@RequestBody List<UserExamOption> list, HttpServletRequest httpServletRequest) {
        User user = (User) httpServletRequest.getAttribute("id");
        System.out.println(list);
        System.out.println(user);

        double rightNum = 0;
        for (UserExamOption item : list) {
            item.setUserId(user.getId());

            Problem problem = problemService.getById(item.getProblemId());
            System.out.println(problem);
            if (
                    problem.getChoiceAIsTrue()==item.getChoiceAIsTrue()&&
                    problem.getChoiceBIsTrue()==item.getChoiceBIsTrue()&&
                    problem.getChoiceCIsTrue()==item.getChoiceCIsTrue()&&
                    problem.getChoiceDIsTrue()==item.getChoiceDIsTrue()
            )   rightNum = rightNum + 1.0;
        }
        iUserExamOptionService.saveOrUpdateBatch(list);
        double score = rightNum/list.size() * 100.0;
        UserExam userExam = new UserExam();
        userExam.setExamId(list.get(0).getExamId());
        userExam.setUserId(user.getId());
        userExam.setScore(score);
        userExamService.updateScore(userExam);
        return "ok";
    }
}
