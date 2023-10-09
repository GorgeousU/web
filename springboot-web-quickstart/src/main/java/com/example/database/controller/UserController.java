package com.example.database.controller;

import com.example.database.entity.User;
import com.example.database.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/select")
    public List<User> selectAll(){
        return userService.selectAll();
    }
    @GetMapping("/select/{id}")
    public User selectById(@PathVariable String id){
        return userService.selectById(id);
    }
    @PostMapping("/insert")
    public void insert(@RequestBody User user){
        userService.insert(user);
    }
    @PutMapping("/update")
    public void update(@RequestBody User user){
        userService.update(user);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        userService.delete(id);
    }
}
