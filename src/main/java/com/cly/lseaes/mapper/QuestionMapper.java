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

    @Select("select question.* from question left join question_repository qr on question.id = qr.question_id and qr.repository_id = #{repo_id} ORDER BY RAND() limit #{count};")
    List<Question> selectQuListByRepoIdAndCount(Integer repositoryId, Integer count);
}
