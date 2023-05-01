package com.cly.lseaes.service;

import com.cly.lseaes.entity.QuestionAnswer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 试题答案选项 服务类
 * </p>
 *
 * @author cly
 * @since 2023-04-30
 */
public interface IQuestionAnswerService extends IService<QuestionAnswer> {

    List<QuestionAnswer> listAnswerByRandom(Integer quId);
}
