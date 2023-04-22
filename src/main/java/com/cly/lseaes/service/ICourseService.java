package com.cly.lseaes.service;

import com.cly.lseaes.dto.CourseDTO;
import com.cly.lseaes.entity.Course;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cly
 * @since 2023-04-12
 */
public interface ICourseService extends IService<Course> {

    CourseDTO selectCourseDTOById(Integer id);
}
