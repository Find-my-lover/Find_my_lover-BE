package com.gamjaring.web.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @CrossOrigin("*")
    @GetMapping("/api/home")
    public String home(){
        return "home";
    }
}
