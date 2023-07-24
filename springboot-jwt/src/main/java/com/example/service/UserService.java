package com.example.service;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.util.JwtUtil;
import com.example.util.Result;
import com.example.util.TokenBlackList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public Result login(User user) {
        User login = userMapper.login(user);
        if (login == null) {
            return Result.error();
        }
        String token = JwtUtil.sign(login);
        TokenBlackList.removeFromRevokedToken(token);
        return Result.ok().data("token",token);
    }

}
