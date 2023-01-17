package com.gamjaring.web.springboot.config.auth;

import com.gamjaring.web.springboot.user.*;
import lombok.RequiredArgsConstructor;
import org.h2.engine.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


/*
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;
    //아 SOLID원칙 깨지는데...
    //일단 이렇게 하되 어떻게 바꿔야할지 고민하기
*/
    @Autowired
    private CustomUserDetailsService customUserDetailsService;


    @Bean
    public PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();

    }

    //http요청에 대한 보안을 설정한다.
    //페이지 권한, 로그인 페이지, 로그아웃 메서드 등에 대한 설정을 작성한다.

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.formLogin()

                .loginPage("/login")
                .defaultSuccessUrl("/")
                .usernameParameter("email")
                .failureUrl("/login/error")
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/use/logout"))
                .logoutSuccessUrl("/");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web
                .ignoring().antMatchers( "/css/**", "/js/**", "/img/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(customUserDetailsService)
        .passwordEncoder(passwordEncoder());
    }



}
