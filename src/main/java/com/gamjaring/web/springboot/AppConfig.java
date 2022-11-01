package com.gamjaring.web.springboot;

import com.gamjaring.web.springboot.user.UserRepository;
import com.gamjaring.web.springboot.user.UserService;
import com.gamjaring.web.springboot.user.UserServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

@Configuration
public class AppConfig {

    UserRepository userRepository;

    @Bean
    public UserService userService(){
        return new UserServiceImpl(userRepository);
    }


}
