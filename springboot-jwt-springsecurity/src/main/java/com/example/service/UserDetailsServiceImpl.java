package com.example.service;

import com.example.entity.JwtUser;
import com.example.mapper.JwtUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private JwtUserMapper jwtUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        JwtUser jwtUser = jwtUserMapper.selectByName(username);
        if(jwtUser == null) {
            throw new UsernameNotFoundException("用户不存在");
        }
        return User
                .withUsername(jwtUser.getUsername())
                .password(jwtUser.getPassword())
                .authorities("ROLE_USER")
                .build();
    }
}
