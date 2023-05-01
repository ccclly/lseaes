package com.cly.lseaes.service;

import com.cly.lseaes.entity.Paper;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cly
 * @since 2023-04-30
 */
public interface IPaperService extends IService<Paper> {

    String acreatePaper(Integer userId, Integer examId);
}
