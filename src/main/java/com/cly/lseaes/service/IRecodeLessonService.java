package com.cly.lseaes.service;

import com.cly.lseaes.entity.RecodeLesson;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cly
 * @since 2023-05-01
 */
public interface IRecodeLessonService extends IService<RecodeLesson> {

    Integer getProcessForCourse(Integer courseId, Integer userId);

    Integer getProcessForLesson(Integer courseId, Integer userId, Integer lessonId);
}
