package com.cly.lseaes.service;

import com.cly.lseaes.entity.UserExam;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cly
 * @since 2023-04-24
 */
public interface IUserExamService extends IService<UserExam> {

    boolean insertUerExam(UserExam userExam);

    boolean deleteUerExam(UserExam userExam);

    boolean updateScore(UserExam userExam);
}
