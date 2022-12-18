package com.gamjaring.web.springboot.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//매핑만 하고 현재까지는 경로지정은 없음
@Api(tags={"home"})
@RestController
public class HomeController {

//    @CrossOrigin("*")
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
