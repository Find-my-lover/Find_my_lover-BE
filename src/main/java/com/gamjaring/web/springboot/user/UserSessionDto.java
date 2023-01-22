package com.gamjaring.web.springboot.user;

import java.io.Serializable;


public class UserSessionDto implements Serializable {
    private String name;
    private String password;
    private String email;

    public UserSessionDto(Member member){
        this.name=member.getName();
        this.password= member.getPassword();
        this.email=member.getEmail();
    }

}
