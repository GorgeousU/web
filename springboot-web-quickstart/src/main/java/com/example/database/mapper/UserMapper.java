package com.example.database.mapper;

import com.example.database.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserMapper {
    List<User> selectAll();
    User selectById(String id);
    void insert(User user);
    void update(User user);
    void delete(String id);
}
