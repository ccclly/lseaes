package com.cly.lseaes.service.impl;

import com.cly.lseaes.entity.Question;
import com.cly.lseaes.mapper.QuestionMapper;
import com.cly.lseaes.service.IQuestionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 试题主表 服务实现类
 * </p>
 *
 * @author cly
 * @since 2023-04-30
 */
@Service
public class QuestionServiceImpl extends ServiceImpl<QuestionMapper, Question> implements IQuestionService {
    @Autowired
    private QuestionMapper mapper;

    @Override
    public List<Question> selectQuListByRepoIdAndCount(Integer repositoryId, Integer count){
        return mapper.selectQuListByRepoIdAndCount(repositoryId, count);
    }
}
