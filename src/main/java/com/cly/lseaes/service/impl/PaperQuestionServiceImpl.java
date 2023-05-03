package com.cly.lseaes.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cly.lseaes.entity.PaperQuestion;
import com.cly.lseaes.mapper.PaperQuestionMapper;
import com.cly.lseaes.service.IPaperQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cly
 * @since 2023-04-30
 */
@Service
public class PaperQuestionServiceImpl extends ServiceImpl<PaperQuestionMapper, PaperQuestion> implements IPaperQuestionService {

    @Override
    public List<PaperQuestion> listByPaper(Integer paperId) {

        //查询条件
        QueryWrapper<PaperQuestion> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(PaperQuestion::getPaperId, paperId)
                .orderByAsc(PaperQuestion::getSort);

        return this.list(wrapper);
    }

    @Override
    public void updateByKey(PaperQuestion qu) {

        //查询条件
        QueryWrapper<PaperQuestion> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(PaperQuestion::getPaperId, qu.getPaperId())
                .eq(PaperQuestion::getQuestionId, qu.getQuestionId());

        this.update(qu, wrapper);
    }
}
