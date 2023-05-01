package com.cly.lseaes.controller;


import com.cly.lseaes.dto.ProblemExamDTO;
import com.cly.lseaes.entity.Exam;
import com.cly.lseaes.entity.ExamProblem;
import com.cly.lseaes.service.IExamProblemService;
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
@RequestMapping("/exam-problem")
public class ExamProblemController {
    @Autowired
    private IExamProblemService iExamProblemService;

    @PostMapping("/update/{id}")
    public String update(@RequestBody List<ProblemExamDTO> list, @PathVariable Integer id){

        for (ProblemExamDTO item : list) {
            ExamProblem examProblem = new ExamProblem();
            examProblem.setExamId(id);
            examProblem.setProblemId(item.getId());
            if (item.getSelected() == 1) {
                iExamProblemService.insertProblemExam(examProblem);
            } else {
                iExamProblemService.deleteExamProblem(examProblem);
            }
        }

        return "ok";
    }
}
