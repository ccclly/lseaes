package com.cly.lseaes.service;

import com.cly.lseaes.entity.Question;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * <p>
 * 试题主表 服务类
 * </p>
 *
 * @author cly
 * @since 2023-04-30
 */
public interface IQuestionService extends IService<Question> {

    List<Question> selectQuListByRepoIdAndCount(Integer repositoryId, Integer count);

    List<Question> selectQuListByPaperId(Integer id);

    List<Question> selectQuListByR(Integer num);
}
