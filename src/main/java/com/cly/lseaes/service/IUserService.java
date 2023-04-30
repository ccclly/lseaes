package com.cly.lseaes.service;

import com.cly.lseaes.dto.UserExamDTO;
import com.cly.lseaes.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cly
 * @since 2023-04-09
 */
public interface IUserService extends IService<User> {
    User login(String username, String password);

    List<UserExamDTO> selectUserExamDTOById(Integer id);
}
