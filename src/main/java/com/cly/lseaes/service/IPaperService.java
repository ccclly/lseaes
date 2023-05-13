package com.cly.lseaes.service;

import com.cly.lseaes.entity.Paper;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletRequest;
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

    void finishPaper(Integer paperId);

    HashMap<String, Object> getPaperById(Integer paperId);

    String fillAns(Integer paperId, Integer questionId, List<Integer> ansIds);

    Double countScore(Integer paperId);

    HashMap<String, Object> createPaperForTest(Integer num, Integer userId);
}
