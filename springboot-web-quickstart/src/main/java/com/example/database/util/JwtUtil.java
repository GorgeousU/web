package com.example.database.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    //7天过期，这里为毫秒
    private static final long expire = 604800;
    //32位密钥
    private static final String secret = "qwertyuiopasdfghjklzxcvbnmqwerty";

    //生成token
    public static String generateToken(String username) {
        Date now = new Date();
        Date expiration = new Date(now.getTime() + 1000 * expire);
        return Jwts.builder()
                .setHeaderParam("type","JWT")
                .setSubject(username)
                .setIssuedAt(now)    //生效时间
                .setExpiration(expiration)   //过期时间
                .signWith(SignatureAlgorithm.HS256,secret)   //算法
                .compact();
    }

    //解析token
    public static Claims getClaimsToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)  //传进密钥
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            return null;
        }
    }

    //判断令牌是否有效
    public static boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
