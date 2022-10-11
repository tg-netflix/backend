package com.techgrounds.netflix.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class netflixController {

    @GetMapping("/")
    public String getHello() {
        return "Hello Netflix Project";
    }
}
