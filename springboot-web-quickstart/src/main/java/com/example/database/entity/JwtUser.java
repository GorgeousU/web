package com.example.database.entity;

import lombok.Data;

@Data

public class JwtUser {
    private String username;
    private String password;

    public JwtUser() {
    }

    public JwtUser(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
