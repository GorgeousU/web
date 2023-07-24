package com.example.controller;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class JwtController {
    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        return userService.login(user);
    }

    @RequestMapping("/test")
    public Object test() {
        return "访问成功";
    }
}
