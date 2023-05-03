package com.cly.lseaes.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cly.lseaes.entity.Lesson;
import com.cly.lseaes.entity.RecodeLesson;
import com.cly.lseaes.mapper.RecodeLessonMapper;
import com.cly.lseaes.service.ILessonService;
import com.cly.lseaes.service.IRecodeLessonService;
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
 * @since 2023-05-01
 */
@Service
public class RecodeLessonServiceImpl extends ServiceImpl<RecodeLessonMapper, RecodeLesson> implements IRecodeLessonService {
    @Autowired
    private RecodeLessonMapper mapper;
    @Autowired
    private ILessonService lessonService;

    @Override
    public Integer getProcessForCourse(Integer courseId, Integer userId){
        QueryWrapper<RecodeLesson> wrapper= new QueryWrapper<>();
        wrapper.eq("course_id", courseId)
                .eq("user_id", userId);
        List<RecodeLesson> list = mapper.selectList(wrapper);
        QueryWrapper<Lesson> wrapper1 = new QueryWrapper<>();
        wrapper1.eq("course_id", courseId);
        List<Lesson> lessons = lessonService.list(wrapper1);
        int count = 0, result = 0;
        for (RecodeLesson recodeLesson : list) {
            count += recodeLesson.getProcess();
        }

        return count / lessons.size();
    }
    @Override
    public Integer getProcessForLesson(Integer courseId, Integer userId, Integer lessonId){
        QueryWrapper<RecodeLesson> wrapper= new QueryWrapper<>();
        wrapper.eq("course_id", courseId)
                .eq("user_id", userId)
                .eq("lesson_id", lessonId);
        List<RecodeLesson> list = mapper.selectList(wrapper);


        return list.get(0).getProcess();
    }


}
