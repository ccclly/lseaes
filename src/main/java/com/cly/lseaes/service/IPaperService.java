package com.cly.lseaes.service;

import com.cly.lseaes.entity.Paper;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.HashMap;
import java.util.List;

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

    String fillAns(Integer paperId, Integer questionId, List<Integer> ansIds);

    Double countScore(Integer paperId);
}
