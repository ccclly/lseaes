package com.cly.lseaes.mapper;

import com.cly.lseaes.entity.Question;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 * 试题主表 Mapper 接口
 * </p>
 *
 * @author cly
 * @since 2023-04-30
 */
public interface QuestionMapper extends BaseMapper<Question> {

    @Select("select * from question where question.repository_id = #{repositoryId} ORDER BY RAND() limit #{count};")
    List<Question> selectQuListByRepoIdAndCount(Integer repositoryId, Integer count);

    @Select("select question.* from question left join paper_question pq on question.id = pq.question_id where pq.paper_id = #{id}")
    List<Question> selectQuListByPaperId(Integer id);

    @Select("select * from question ORDER BY RAND() limit #{num};")
    List<Question> selectQuListByR(Integer num);
}
