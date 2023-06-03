package com.cly.lseaes.service.impl;

import com.cly.lseaes.dto.EnterDTO;
import com.cly.lseaes.entity.EnterPermit;
import com.cly.lseaes.entity.UserExam;
import com.cly.lseaes.mapper.EnterPermitMapper;
import com.cly.lseaes.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cly
 * @since 2023-05-10
 */
@Service
public class EnterPermitServiceImpl extends ServiceImpl<EnterPermitMapper, EnterPermit> implements IEnterPermitService {

    @Autowired
    private IExamService examService;
    @Autowired
    private ICourseService courseService;
    @Autowired
    private IUserExamService userExamService;
    @Autowired
    private IRecodeLessonService recodeLessonService;

    @Override
    public List<EnterDTO> getByUser(Integer userId) {
        List<EnterPermit> list = this.list();
        List<EnterDTO> res = new ArrayList<>();
        for (EnterPermit enterPermit : list) {
            EnterDTO enterDTO = new EnterDTO();
            enterDTO.setEnterPermit(enterPermit);
            enterDTO.setExam(examService.getById(enterPermit.getExamId()));
            enterDTO.setCourse(courseService.getById(enterPermit.getCourseId()));
            UserExam userExam = userExamService.getUserExam(userId, enterPermit.getExamId());
            enterDTO.setExamPass(userExam != null && userExam.getScore()*100.0 >= enterPermit.getExamScore());
            Integer courseScore = recodeLessonService.getProcessForCourse(enterPermit.getCourseId(), userId);
            enterDTO.setCoursePass(courseScore >= enterPermit.getCourseScore());
            res.add(enterDTO);
        }
        return res;
    }
}
