package com.cly.lseaes.service;

import com.cly.lseaes.dto.EnterDTO;
import com.cly.lseaes.entity.EnterPermit;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cly
 * @since 2023-05-10
 */
public interface IEnterPermitService extends IService<EnterPermit> {

    List<EnterDTO> getByUser(Integer userId);
}
