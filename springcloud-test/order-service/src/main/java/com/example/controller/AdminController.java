package com.example.controller;

import com.example.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;


@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;
    @GetMapping("/user-service/hi")
    public String sayHi(@RequestParam String message) {
        return adminService.sayHi(message);
    }

}

