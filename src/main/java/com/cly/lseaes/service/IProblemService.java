package com.cly.lseaes.service;

import com.cly.lseaes.dto.ProblemExamDTO;
import com.cly.lseaes.entity.Problem;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cly
 * @since 2023-04-18
 */
public interface IProblemService extends IService<Problem> {

    List<ProblemExamDTO> selectProblemExamDTOById(Integer id);

    List<Problem> selectProblemByExamId(Integer id);

    List<Problem> getRAND(Integer num);
}
