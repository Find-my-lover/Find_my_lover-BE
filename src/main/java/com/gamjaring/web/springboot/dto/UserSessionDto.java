package com.gamjaring.web.springboot.dto;

import com.gamjaring.web.springboot.domain.Member;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class UserSessionDto implements Serializable {
    private final String name;
    private final String password;
    private final String email;

    public UserSessionDto(Member member){
        this.name=member.getName();
        this.password= member.getPassword();
        this.email=member.getEmail();
    }

}
