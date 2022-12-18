package com.gamjaring.web.springboot.controller;

import com.gamjaring.web.springboot.user.Member;
import com.gamjaring.web.springboot.user.UserForm;
import com.gamjaring.web.springboot.user.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders;
import org.springframework.security.test.web.servlet.response.SecurityMockMvcResultMatchers;
import org.springframework.test.web.servlet.MockMvc;


import javax.transaction.Transactional;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestBuilders.formLogin;

@SpringBootTest
@AutoConfigureMockMvc
//테스트를 위해 브라우저나 WAS의 동작을 똑같이 처리해주는 환경 제공
@Transactional
public class UserControllerTest {

    @Autowired
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    PasswordEncoder passwordEncoder;

    //로그인하기위해 회원가입이 되어있는 유저를 미리 만들 수 있는 메서드 설정
    public Member createUser(String email, String password){
       UserForm userForm=new UserForm();
       userForm.setEmail(email);
       userForm.setName("예무무");
       userForm.setPassword(password);
       Member user=Member.createUser(userForm, passwordEncoder);
       return userService.createUser(user);
    }

    @Test
    @DisplayName("로그인 성공 테스트")
    public void loginSuccessTest() throws Exception{
        String email="yerinyoon@ewhain.net";
        String password="1234";
        this.createUser(email, password);

        mockMvc.perform(formLogin().userParameter("email")
                .loginProcessingUrl("users/login")
                .user(email).password(password))
                .andExpect(SecurityMockMvcResultMatchers.authenticated());//로그인이 성공었나?
    }


}
