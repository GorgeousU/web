package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ConsumerController {
    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/message")
    public String getMessage() {
        List<ServiceInstance> instances = discoveryClient.getInstances("nacos-client");
        if (instances.size() == 0) {
            return "No instances available";
        }
        ServiceInstance serviceInstance = instances.get(0);
        String url = serviceInstance.getUri() + "/api/message";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url,String.class);
    }
}
