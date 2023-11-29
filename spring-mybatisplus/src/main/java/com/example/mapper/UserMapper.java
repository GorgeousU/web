package com.example.mapper;

import com.example.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users")
    List<User> select();
    @Insert("INSERT INTO users VALUES(#{id},#{username},#{password})")
    void insert(User user);
    @Update("UPDATE users SET username=#{username},password=#{password} WHERE id=#{id}")
    void update(User user);
    @Delete("DELETE FROM users WHERE id=#{id}")
    void delete(String id);
}
