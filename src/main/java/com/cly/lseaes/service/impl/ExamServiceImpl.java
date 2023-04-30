package com.cly.lseaes.service.impl;

import com.cly.lseaes.entity.Exam;
import com.cly.lseaes.mapper.ExamMapper;
import com.cly.lseaes.service.IExamService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cly
 * @since 2023-04-24
 */
@Service
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements IExamService {

    @Autowired
    private ExamMapper examMapper;
    @Override
    public List<Exam> selectExamByUserId(Integer id){
        return examMapper.selectExamByUserId(id);
    }
}
