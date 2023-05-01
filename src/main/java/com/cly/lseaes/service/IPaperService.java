package com.cly.lseaes.service;

import com.cly.lseaes.entity.Paper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cly
 * @since 2023-04-30
 */
public interface IPaperService extends IService<Paper> {

    HashMap<String, Object> acreatePaper(Integer userId, Integer examId);

    HashMap<String, Object> getPaperById(Integer paperId);
}
