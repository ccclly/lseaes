package com.cly.lseaes.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cly.lseaes.constant.ErrorMessage;
import com.cly.lseaes.entity.User;
import com.cly.lseaes.mapper.UserMapper;
import com.cly.lseaes.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cly
 * @since 2023-04-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {
    @Override
    public User login(String username, String password) {
        User user = this.getOne(Wrappers.<User>lambdaQuery().eq(User::getName, username));
        if (user == null) {
            throw new RuntimeException(ErrorMessage.ACCOUNT_NOT_FOUND);
        } else if (!Objects.equals(password, user.getPassword())) {
            throw new RuntimeException(ErrorMessage.PASSWORD_ERROR);
        }

        return user;
    }
}
