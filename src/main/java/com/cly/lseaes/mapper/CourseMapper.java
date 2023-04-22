package com.cly.lseaes.mapper;

import com.cly.lseaes.dto.CourseDTO;
import com.cly.lseaes.entity.Course;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cly
 * @since 2023-04-12
 */
public interface CourseMapper extends BaseMapper<Course> {
    @Select("SELECT c.*, ch.id AS chapter_id, ch.name AS chapter_name, ch.order_num AS chapter_order_num, l.id AS lesson_id, l.name AS lesson_name, l.order_num AS lesson_order_num, l.vedio_name AS lesson_vedio_name FROM course c LEFT JOIN chapter ch ON c.id = ch.course_id LEFT JOIN lesson l ON ch.id = l.chapter_id WHERE c.id = #{id}")
    List<Map<String, Object>> selectCourseDetailsById(Integer id);

//    CourseDTO selectCourseDTOById(Integer id);
}
