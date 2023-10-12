package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TestService {
    @Autowired
    private RestTemplate restTemplate;
    public String sayHi(String message) {
        return restTemplate.getForObject("http://USER-SERVICE/hi?message=" + message,String.class);
    }
}
