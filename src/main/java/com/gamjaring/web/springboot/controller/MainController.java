package com.gamjaring.web.springboot.controller;

import com.gamjaring.web.springboot.user.Gender;
import com.gamjaring.web.springboot.user.UserService;
import com.gamjaring.web.springboot.user.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;

@Api(tags={"Main"})
@RestController(value = "/main")
public class MainController {
    private final UserServiceImpl userServiceImpl;

    @Autowired
    public MainController(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

    @ApiOperation(value = "결과화면")
    @PostMapping("/result")
    public ResponseEntity<?> select(@RequestBody String email, Gender gender, MultipartFile image, Model model) {
        UserDetails user = userServiceImpl.loadUserByUsername(email);
        return ResponseEntity.ok().build();
    }
}
