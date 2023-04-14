package com.cly.lseaes.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cly.lseaes.constant.ErrorMessage;
import com.cly.lseaes.entity.Admin;
import com.cly.lseaes.mapper.AdminMapper;
import com.cly.lseaes.service.IAdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cly
 * @since 2023-04-03
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements IAdminService {

    @Override
    public Admin login(String username, String password) {
        Admin admin = this.getOne(Wrappers.<Admin>lambdaQuery().eq(Admin::getName, username));
        if (admin == null) {
            throw new RuntimeException(ErrorMessage.ACCOUNT_NOT_FOUND);
        } else if (!Objects.equals(password, admin.getPassword())) {
            throw new RuntimeException(ErrorMessage.PASSWORD_ERROR);
        }

        return admin;
    }
}
