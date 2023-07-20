package com.example.controller;


import com.example.entity.JwtUser;
import com.example.service.UserDetailsServiceImpl;
import com.example.util.JwtUtil;
import com.example.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    private AuthenticationManager authenticationManager;
    @Autowired
    private UserDetailsServiceImpl userDetailsService;
    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/login")
    public Result login(@RequestBody JwtUser jwtUser) {
        //身份验证
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(jwtUser.getUsername(),jwtUser.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        //生成JWT令牌
        UserDetails userDetails = userDetailsService.loadUserByUsername(jwtUser.getUsername());
        String token = JwtUtil.generateToken(userDetails.getUsername());
        return Result.ok().data("token",token);
    }

    @GetMapping("/success")
    public String success() {
        return "Success";
    }
    @GetMapping("/fail")
    public String fail() {
        return "Fail";
    }


    @PostMapping("/logout")
    public Result logout() {
        SecurityContextHolder.getContext().setAuthentication(null);
        return Result.ok();
    }
}
