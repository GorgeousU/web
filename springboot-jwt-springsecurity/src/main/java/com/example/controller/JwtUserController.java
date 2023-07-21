package com.example.controller;

import com.example.entity.JwtUser;

import com.example.util.JwtUtil;
import com.example.util.Result;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class JwtUserController {

    @PostMapping("/login")
    public Result login(@RequestBody JwtUser jwtUser) {

        String token = JwtUtil.generateToken(jwtUser.getUsername());
        return Result.ok().data("token",token);
    }

    @GetMapping("/info")
    public Result info(String token) {
        String username = JwtUtil.getClaimsToken(token).getSubject();
        String url = "https://img2.baidu.com/it/u=1325995315,4158780794&fm=26&fmt=auto&gp=0.jpg";
        return Result.ok().data("name",username).data("avatar",url);
    }

    @PostMapping("/logout")
    public Result logout() {
        return Result.ok();
    }

}

