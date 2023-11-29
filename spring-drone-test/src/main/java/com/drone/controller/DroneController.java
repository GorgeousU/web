package com.drone.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DroneController {
    @RequestMapping("/drone")
    public String index() {
        return "Hello Drone";
    }
}
