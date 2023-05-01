package com.cly.lseaes.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cly.lseaes.entity.QuestionAnswer;
import com.cly.lseaes.mapper.QuestionAnswerMapper;
import com.cly.lseaes.service.IQuestionAnswerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 试题答案选项 服务实现类
 * </p>
 *
 * @author cly
 * @since 2023-04-30
 */
@Service
public class QuestionAnswerServiceImpl extends ServiceImpl<QuestionAnswerMapper, QuestionAnswer> implements IQuestionAnswerService {

    @Override
    public List<QuestionAnswer> listAnswerByRandom(Integer quId) {
        QueryWrapper<QuestionAnswer> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(QuestionAnswer::getQuestionId, quId);
        wrapper.last(" ORDER BY RAND() ");

        return this.list(wrapper);
    }
}
