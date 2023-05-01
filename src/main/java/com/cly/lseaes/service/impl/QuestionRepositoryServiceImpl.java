package com.cly.lseaes.service.impl;

import com.cly.lseaes.entity.QuestionRepository;
import com.cly.lseaes.mapper.QuestionRepositoryMapper;
import com.cly.lseaes.service.IQuestionRepositoryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 试题题库关联 服务实现类
 * </p>
 *
 * @author cly
 * @since 2023-04-30
 */
@Service
public class QuestionRepositoryServiceImpl extends ServiceImpl<QuestionRepositoryMapper, QuestionRepository> implements IQuestionRepositoryService {

}
