package com.gamjaring.web.springboot.user;

import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails{

    private final Member user;

    @Override
    public String getPassword(){
        return user.getPassword();
    }

    @Override
    public String getPassword(){
        return user.getPassword();
    }

    @Override
    public String get
}
