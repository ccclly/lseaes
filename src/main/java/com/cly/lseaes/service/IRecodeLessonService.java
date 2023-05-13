package com.cly.lseaes.service;

import com.cly.lseaes.dto.RecordDTO;
import com.cly.lseaes.entity.RecodeLesson;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cly
 * @since 2023-05-01
 */
public interface IRecodeLessonService extends IService<RecodeLesson> {

    List<RecordDTO> getProcessList(Integer userId);

    Integer getProcessForCourse(Integer courseId, Integer userId);

    Integer getProcessForLesson(Integer courseId, Integer userId, Integer lessonId);
}
