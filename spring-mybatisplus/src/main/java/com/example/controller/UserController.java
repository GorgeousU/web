package com.example.controller;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @GetMapping("/select")
    public List<User> select() {
        return userMapper.select();
    }
    @PostMapping("/insert")
    public void insert(@RequestBody User user) {
        userMapper.insert(user);
    }
    @PutMapping("/update")
    public void update(@RequestBody User user) {
        userMapper.update(user);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        userMapper.delete(id);
    }

}
