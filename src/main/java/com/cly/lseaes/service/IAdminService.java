package com.cly.lseaes.service;

import com.cly.lseaes.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cly
 * @since 2023-04-03
 */
public interface IAdminService extends IService<Admin> {
    Admin login(String username, String password);
}
