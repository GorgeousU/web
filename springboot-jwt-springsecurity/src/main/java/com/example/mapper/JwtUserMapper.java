package com.example.mapper;

import com.example.entity.JwtUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface JwtUserMapper {
    JwtUser login(JwtUser jwtUser);
}
