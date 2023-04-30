package com.cly.lseaes.service;

import com.cly.lseaes.entity.Exam;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author cly
 * @since 2023-04-24
 */
public interface IExamService extends IService<Exam> {

    List<Exam> selectExamByUserId(Integer id);
}
