package com.cly.lseaes.service;

import com.cly.lseaes.entity.PaperQuestion;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cly
 * @since 2023-04-30
 */
public interface IPaperQuestionService extends IService<PaperQuestion> {

    List<PaperQuestion> listByPaper(Integer paperId);

    void updateByKey(PaperQuestion qu);
}
