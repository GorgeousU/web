package com.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

@FeignClient(value = "user-service")
@Service
public interface AdminService {
    @GetMapping("/user-service/hi")
    String sayHi(@RequestParam(value = "message") String message);
}
