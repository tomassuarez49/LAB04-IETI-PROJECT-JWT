package com.edu.eci.ieti.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {
    
    @GetMapping("/health") 
    public String checkApi() {
        return "<h1>The API is working ok!</h1>";
    }

}

