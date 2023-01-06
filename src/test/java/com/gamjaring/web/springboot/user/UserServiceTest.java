package com.gamjaring.web.springboot.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@SpringBootTest
@Transactional
public class UserServiceTest {
    @Autowired
    UserService userService;

    @Autowired
    PasswordEncoder passwordEncoder;

    public Member createUser(){
        UserDto userDto =new UserDto();
        userDto.setEmail("yerinyoon@ewhain.net");
        userDto.setName("예린");
        userDto.setPassword("12345");
        return Member.createUser(userDto, passwordEncoder);
    }

    @Test
    @DisplayName("회원 가입 테스트")
    public void saveUserTest(){
        Member user=createUser();
        Member savedUser=userService.createUser(user);

        assertEquals(user.getEmail(), savedUser.getEmail());
        assertEquals(user.getName(), savedUser.getName());
        assertEquals(user.getPassword(), savedUser.getPassword());

    }

    @Test
    @DisplayName("중복 회원가입 테스트")
    public void saveDuplicateMemberTest(){
        Member user1=createUser();
        Member user2=createUser();
        userService.createUser(user1);

        Throwable e =assertThrows(IllegalStateException.class, ()->{
            userService.createUser(user2);});
        assertEquals("이미 가입된 회원입니다.", e.getMessage());

    }


}
