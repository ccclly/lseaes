package com.cly.lseaes.controller;


import com.auth0.jwt.interfaces.DecodedJWT;
import com.cly.lseaes.dto.UserExamDTO;
import com.cly.lseaes.entity.User;
import com.cly.lseaes.service.IUserService;
import com.cly.lseaes.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author cly
 * @since 2023-04-09
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @PostMapping("/list")
    public List<User> userList() {
        return userService.list();
    }

    @GetMapping("/list_exam/{id}")
    public List<UserExamDTO> getUserExamDto(@PathVariable Integer id) {
        return userService.selectUserExamDTOById(id);
    }

    @PostMapping("/save")
    public List<User> save(@RequestBody User user){
        userService.save(user);
        return userService.list();
    }

    @PostMapping("/update")
    public String update(@RequestBody User user) {
        userService.updateById(user);
        return "ok";
    }

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody User user) {
        User user1 = userService.login(user.getName(), user.getPassword());

        Map<String, String> userMap = new HashMap<>();
        userMap.put("id", user1.getId().toString());
        userMap.put("name", user1.getName());
        String token = null, user_type = "user";
        token = JwtUtil.getUserToken(userMap);

        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("id", user1.getId().toString());
        resultMap.put("name", user1.getName());
        resultMap.put("grade", user1.getGrade());
        resultMap.put("college", user1.getCollege());
        resultMap.put("major", user1.getMajor());
        resultMap.put("user_type", user1.getUserType().toString());
        resultMap.put("token", token);
        return resultMap;
    }

    @GetMapping("/test")
    public String test(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        String token = httpServletRequest.getHeader("token");
        DecodedJWT decodedJWT = JwtUtil.verifyUserToken(token);
        String id = decodedJWT.getClaim("id").asString();
        String name = decodedJWT.getClaim("name").asString();
        return id+name+"token的登录验证，成功";
    }
}
