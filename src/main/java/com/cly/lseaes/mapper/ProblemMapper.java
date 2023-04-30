package com.cly.lseaes.mapper;

import com.cly.lseaes.dto.ProblemExamDTO;
import com.cly.lseaes.entity.Problem;
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
 * @since 2023-04-18
 */
public interface ProblemMapper extends BaseMapper<Problem> {

    @Select("SELECT problem.* FROM problem ORDER BY RAND() LIMIT #{num};")
    List<Problem> getRAND(Integer num);

    @Select("select problem.*, case when exam_problem.exam_id is null then 0 else 1 end as selected from problem left join exam_problem on problem.id = exam_problem.problem_id and exam_problem.exam_id = #{id};")
    List<Map<String, Object>> selectProblemUserById(Integer id);

    @Select("SELECT p.id, p.name, p.type, p.choice_a,  p.choice_b, p.choice_c, p.choice_d FROM problem p JOIN exam_problem ep ON p.id = ep.problem_id WHERE ep.exam_id = #{id}")
    List<Problem> selectProblemByExamId(Integer id);
}
