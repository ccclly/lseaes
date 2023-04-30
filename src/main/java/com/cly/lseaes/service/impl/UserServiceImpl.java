package com.cly.lseaes.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.cly.lseaes.constant.ErrorMessage;
import com.cly.lseaes.dto.UserExamDTO;
import com.cly.lseaes.entity.User;
import com.cly.lseaes.mapper.UserMapper;
import com.cly.lseaes.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cly
 * @since 2023-04-09
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    UserMapper userMapper;
    @Override
    public User login(String username, String password) {
        User user = this.getOne(Wrappers.<User>lambdaQuery().eq(User::getName, username));
        if (user == null) {
            throw new RuntimeException(ErrorMessage.ACCOUNT_NOT_FOUND);
        } else if (!Objects.equals(password, user.getPassword())) {
            throw new RuntimeException(ErrorMessage.PASSWORD_ERROR);
        }

        return user;
    }

    @Override
    public List<UserExamDTO> selectUserExamDTOById(Integer id) {
        List<Map<String, Object>> resultList = userMapper.selectUserExamById(id);
        if (resultList.isEmpty()) {
            return null;
        }
        List<UserExamDTO> list = new ArrayList<>();
        for (Map<String, Object> map: resultList){
            UserExamDTO userExamDTO = new UserExamDTO();
            userExamDTO.setId((Integer) map.get("id"));
            userExamDTO.setName((String) map.get("name"));
            userExamDTO.setGrade((String) map.get("grade"));
            userExamDTO.setCollege((String) map.get("college"));
            userExamDTO.setMajor((String) map.get("major"));
            userExamDTO.setScore((Double) map.get("score"));
            userExamDTO.setSelected((Long) map.get("selected"));
            list.add(userExamDTO);
        }
        return list;
    }
}
