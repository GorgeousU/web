package com.example.service;

import com.example.entity.JwtUser;

public interface JwtUserService {
    JwtUser login(JwtUser jwtUser);
}
