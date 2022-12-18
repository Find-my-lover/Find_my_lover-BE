package com.gamjaring.web.springboot.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest
@Transactional
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User createUser(){
        UserForm userForm=new UserForm();
        userForm.setEmail("yerinyoon@ewhain.net");
        userForm.setName("예린");
        userForm.setPassword("12345");
        return User.createUser(userForm, passwordEncoder);
    }

    @Test
    @DisplayName("회원 가입 테스트")
    public void saveUserTest(){
        User user=createUser();
        User savedUser=userService.createUser(user);

        assertEquals(user.getEmail(), savedUser.getEmail());
        assertEquals(user.getName(), savedUser.getName());
        assertEquals(user.getPassword(), savedUser.getPassword());

    }


}
