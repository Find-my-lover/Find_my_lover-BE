package com.gamjaring.web.springboot.VO;

import com.gamjaring.web.springboot.domain.Gender;
import com.gamjaring.web.springboot.domain.Role;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
public class UserVO {

    private Long id;
    private String password;
    private String name;
    private String email;
    private Gender gender;
    private Role role;

}
