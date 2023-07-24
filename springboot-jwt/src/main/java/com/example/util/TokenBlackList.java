package com.example.util;

import java.util.HashSet;
import java.util.Set;

public class TokenBlackList {
    //Set<String>表示一组不重复且无序的字符串元素集合，这里用作黑名单，用以注销功能
    private static final Set<String> revokedTokens = new HashSet<>();

    //将token加入黑名单
    public static void addToRevokedToken(String token) {
        revokedTokens.add(token);
    }

    //将token移出黑名单
    public static void removeFromRevokedToken(String token) {
        revokedTokens.remove(token);
    }

    //检查token是否在黑名单里
    public static boolean isRevoked(String token) {
        return revokedTokens.contains(token);
    }
}
