package com.cly.lseaes.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cly.lseaes.entity.UserExam;
import com.cly.lseaes.mapper.UserExamMapper;
import com.cly.lseaes.service.IUserExamService;
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
public class UserExamServiceImpl extends ServiceImpl<UserExamMapper, UserExam> implements IUserExamService {

    @Override
    public boolean insertUerExam(UserExam userExam){
        QueryWrapper<UserExam> wrapper = new QueryWrapper<>();
        wrapper.eq("exam_id", userExam.getExamId())
                .eq("user_id", userExam.getUserId());
        UserExam oldUserExam = baseMapper.selectOne(wrapper);
        if (oldUserExam != null){
            return false;
        }else {
            return save(userExam);
        }
    }
    @Override
    public boolean deleteUerExam(UserExam userExam){
        QueryWrapper<UserExam> wrapper = new QueryWrapper<>();
        wrapper.eq("exam_id", userExam.getExamId())
                .eq("user_id", userExam.getUserId());
        baseMapper.delete(wrapper);
        return true;
    }

    @Override
    public boolean updateScore(UserExam userExam) {
        QueryWrapper<UserExam> wrapper = new QueryWrapper<>();
        wrapper.eq("exam_id", userExam.getExamId())
                .eq("user_id", userExam.getUserId());
        baseMapper.update(userExam, wrapper);
        return true;
    }
}
