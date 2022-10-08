package com.gamjaring.web.springboot.auth;

import org.apache.catalina.security.SecurityConfig;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PasswordEncoderTest {

//    @Autowired
//    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @DisplayName("패스워드 암호화 테스트")
    public void passwordEncode(){
        String rawPassword="gamjaring";


        String encodedPassword =passwordEncoder.encode(rawPassword);

        assertAll(
                ()->assertNotEquals(rawPassword, encodedPassword),
                ()->assertTrue(passwordEncoder.matches(rawPassword, encodedPassword))
        );

    }

}
