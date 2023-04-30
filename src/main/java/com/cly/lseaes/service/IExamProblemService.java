package com.cly.lseaes.service;

import com.cly.lseaes.entity.ExamProblem;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cly.lseaes.entity.UserExam;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cly
 * @since 2023-04-24
 */
public interface IExamProblemService extends IService<ExamProblem> {

    boolean insertProblemExam(ExamProblem examProblem);

    boolean deleteExamProblem(ExamProblem examProblem);
}
