package com.example.service;

import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.entity.User;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public List<User> selectAll(){
        return userMapper.selectAll();
    }
    public User selectById(String id){
        return userMapper.selectById(id);
    }
    public void insert(User user){
        userMapper.insert(user);
    }
    public void update(User user){
        userMapper.update(user);
    }
    public void delete(String id){
        userMapper.delete(id);
    }
}
