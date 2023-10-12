package com.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "user-service")
public interface AdminService {
    @GetMapping("/hi")
    String sayHi(@RequestParam(value = "message")String message);
}
