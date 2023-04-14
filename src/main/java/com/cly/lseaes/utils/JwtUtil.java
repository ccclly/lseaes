package com.cly.lseaes.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

public class JwtUtil {
    private static final String USERSIGN = "userdfshfi#%%#*nfhd";//将sign设置成全局变量
//    private static final String ADMINSIGN = "adminshfi#%%#*nfhd";//将sign设置成全局变量

    protected static String getToken(Map<String,String> map, String SIGN){
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE,7);//定义过期时间
        Date date = calendar.getTime();

        JWTCreator.Builder builder = JWT.create();
        map.forEach((k,v)->{
            builder.withClaim(k,v);//使用map的forEach()方法（lambda表达式），动态设置payload
        });

        return builder.withExpiresAt(date)//为token设置过期时间
                .sign(Algorithm.HMAC256(SIGN));
    }

    public static String getUserToken(Map<String, String> map) {
        return getToken(map, USERSIGN);
    }
//    public static String getAdminToken(Map<String, String> map) {
//        return getToken(map, ADMINSIGN);
//    }


    public static DecodedJWT verifyUserToken(String token){
        return JWT.require(Algorithm.HMAC256(USERSIGN)).build().verify(token);
    }
//    public static DecodedJWT verifyAdminToken(String token){
//        return JWT.require(Algorithm.HMAC256(ADMINSIGN)).build().verify(token);
//    }
}