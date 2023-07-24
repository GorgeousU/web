package com.example.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.entity.User;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class JwtUtil {
    //1个小时过期时间
    private static final long expire = 60*60*1000;
    //16位密钥
    private static final String secret = "qwertyuiopasdfgh";



    //创建token
    public static String sign(User user) {
        String token = null;
        Date expiration = new Date(System.currentTimeMillis()+expire);
        token = JWT.create()
                //签发者，可以是任意字符串，指定
                .withIssuer("auth0")
                .withClaim("username",user.getUsername())
                .withClaim("password",user.getPassword())
                .withExpiresAt(expiration)
                .sign(Algorithm.HMAC256(secret));
        return token;
    }

    //验证token
    public static Boolean verify(String token) {
        try {
            //创建token验证器
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(secret)).withIssuer("auth0").build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            //检查token是否已注销
            if (TokenBlackList.isRevoked(token)) {
                throw new JWTVerificationException("令牌已注销");
            }
            System.out.println("认证通过：");
            System.out.println("username：" + JwtUtil.getUsername(token));
            System.out.println("过期时间：" + decodedJWT.getExpiresAt());
            return true;
        }catch (Exception e) {
            return false;
        }
    }


    //获取用户名
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (Exception e) {
            return null;
        }
    }

}
