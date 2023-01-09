package com.gamjaring.web.springboot;

import com.gamjaring.web.springboot.repository.UserRepository;
import com.gamjaring.web.springboot.service.UserService;
import com.gamjaring.web.springboot.service.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class AppConfig {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Bean
    public UserService userService(){
        return new UserServiceImpl(userRepository, passwordEncoder);
    }



}
