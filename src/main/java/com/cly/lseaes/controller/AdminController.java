package com.cly.lseaes.controller;


import com.auth0.jwt.interfaces.DecodedJWT;
import com.cly.lseaes.entity.Admin;
import com.cly.lseaes.service.IAdminService;
import com.cly.lseaes.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cly
 * @since 2023-04-03
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;

    @PostMapping("/login")
    public Map<String, String> login(@RequestBody Admin admin) {
        // TODO: 实现登录逻辑
        Admin admin1 = adminService.login(admin.getName(), admin.getPassword());

        Map<String, String> adminMap = new HashMap<>();
        adminMap.put("id", admin1.getId().toString());
        adminMap.put("name", admin1.getName());
//        String token = JwtUtil.getAdminToken(adminMap);
        Map<String, String> resultMap = new HashMap<>();
        resultMap.put("name", admin1.getName());
//        resultMap.put("token", token);

        return resultMap;
    }

//    @GetMapping("/test")
//    public String test(HttpServletRequest httpServletRequest , HttpServletResponse httpServletResponse) {
//        //获取token
//        String token = httpServletRequest.getHeader("token");
//        //获取DecodedJWT对象
//
//        DecodedJWT decodedJWT = JwtUtil.verifyAdminToken(token);
//        //获取DecodedJWT对象里的payload信息
//        String id = decodedJWT.getClaim("id").asString();
//        String name = decodedJWT.getClaim("name").asString();
//        return id+name+"token的登录验证，成功";
//    }

}
