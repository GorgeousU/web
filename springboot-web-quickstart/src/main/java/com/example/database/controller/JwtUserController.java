package com.example.database.controller;


import com.example.database.entity.JwtUser;
import com.example.database.util.JwtUtil;
import com.example.database.util.Result;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class JwtUserController {

    @PostMapping("/login")
    public Result login(@RequestBody JwtUser jwtUser) {

        String token = JwtUtil.generateToken(jwtUser.getUsername());
        return Result.ok().data("token",token);
    }


    @PostMapping("/logout")
    public Result logout() {
        return Result.ok();
    }
}
