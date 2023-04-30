package com.cly.lseaes.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cly.lseaes.entity.ExamProblem;
import com.cly.lseaes.mapper.ExamProblemMapper;
import com.cly.lseaes.service.IExamProblemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cly
 * @since 2023-04-24
 */
@Service
public class ExamProblemServiceImpl extends ServiceImpl<ExamProblemMapper, ExamProblem> implements IExamProblemService {

    @Override
    public boolean insertProblemExam(ExamProblem examProblem){
        QueryWrapper<ExamProblem> wrapper = new QueryWrapper<>();
        wrapper.eq("exam_id", examProblem.getExamId())
                .eq("problem_id", examProblem.getProblemId());
        ExamProblem oldExamProblem = baseMapper.selectOne(wrapper);
        if (oldExamProblem != null){
            return false;
        }else {
            return save(examProblem);
        }
    }
    @Override
    public boolean deleteExamProblem(ExamProblem examProblem){
        QueryWrapper<ExamProblem> wrapper = new QueryWrapper<>();
        wrapper.eq("exam_id", examProblem.getExamId())
                .eq("problem_id", examProblem.getProblemId());
        baseMapper.delete(wrapper);
        return true;
    }
}
