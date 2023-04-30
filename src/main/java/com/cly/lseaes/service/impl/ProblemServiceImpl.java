package com.cly.lseaes.service.impl;

import com.cly.lseaes.dto.ProblemExamDTO;
import com.cly.lseaes.entity.Problem;
import com.cly.lseaes.mapper.ProblemMapper;
import com.cly.lseaes.service.IProblemService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cly
 * @since 2023-04-18
 */
@Service
public class ProblemServiceImpl extends ServiceImpl<ProblemMapper, Problem> implements IProblemService {
    @Autowired
    private ProblemMapper problemMapper;


    @Override
    public List<ProblemExamDTO> selectProblemExamDTOById(Integer id) {
        List<Map<String, Object>> resultList = problemMapper.selectProblemUserById(id);
        if (resultList.isEmpty()) {
            return null;
        }
        List<ProblemExamDTO> list = new ArrayList<>();
        for (Map<String, Object> map : resultList){
            ProblemExamDTO problemExamDTO = new ProblemExamDTO();
            problemExamDTO.setId((Integer) map.get("id"));
            problemExamDTO.setName((String) map.get("name"));
            problemExamDTO.setType((Integer) map.get("type"));
            problemExamDTO.setChoiceA((String) map.get("choice_a"));
            problemExamDTO.setChoiceB((String) map.get("choice_b"));
            problemExamDTO.setChoiceC((String) map.get("choice_c"));
            problemExamDTO.setChoiceD((String) map.get("choice_d"));
            problemExamDTO.setChoiceAIsTrue((Boolean) map.get("choice_a_is_true"));
            problemExamDTO.setChoiceBIsTrue((Boolean) map.get("choice_b_is_true"));
            problemExamDTO.setChoiceCIsTrue((Boolean) map.get("choice_c_is_true"));
            problemExamDTO.setChoiceDIsTrue((Boolean) map.get("choice_d_is_true"));
            problemExamDTO.setAppearCount((Integer) map.get("appear_count"));
            problemExamDTO.setSelected((Long) map.get("selected"));
            list.add(problemExamDTO);
        }
        return list;
    }

    @Override
    public List<Problem> selectProblemByExamId(Integer id){
        return problemMapper.selectProblemByExamId(id);
    }

    @Override
    public List<Problem> getRAND(Integer num){
        return problemMapper.getRAND(num);}
}
