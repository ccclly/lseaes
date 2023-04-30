package com.cly.lseaes.mapper;

import com.cly.lseaes.entity.Exam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cly
 * @since 2023-04-24
 */
public interface ExamMapper extends BaseMapper<Exam> {

    @Select("SELECT e.* FROM user_exam ue JOIN exam e ON ue.exam_id = e.id WHERE ue.user_id = #{id}")
    List<Exam> selectExamByUserId(Integer id);

}
