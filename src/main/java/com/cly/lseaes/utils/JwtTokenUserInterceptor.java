package com.cly.lseaes.utils;

import com.auth0.jwt.exceptions.AlgorithmMismatchException;
import com.auth0.jwt.exceptions.InvalidClaimException;
import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.cly.lseaes.constant.ErrorMessage;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtTokenUserInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        try {
//            String token = request.getParameter("token");
            String token =  request.getHeader("token");//一般都将token放在请求头中
//            System.out.println(token);
//            System.out.println(token1);


            JwtUtil.verifyUserToken(token);
            return true;
        } catch (Exception e){
            throw new RuntimeException(ErrorMessage.USER_NOT_LOGIN);
        }
    }
}