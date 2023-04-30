package com.cly.lseaes.mapper;

import com.cly.lseaes.entity.User;
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
 * @since 2023-04-09
 */
public interface UserMapper extends BaseMapper<User> {
    @Select("select user.*,user_exam.score, CASE WHEN user_exam.exam_id IS NULL THEN 0 ELSE 1 END AS selected from user left join user_exam on user.id = user_exam.user_id and user_exam.exam_id = #{id}")
    List<Map<String, Object>> selectUserExamById(Integer id);
}
