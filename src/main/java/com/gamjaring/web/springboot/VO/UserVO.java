package com.gamjaring.web.springboot.VO;

import com.gamjaring.web.springboot.enumpack.Gender;
import com.gamjaring.web.springboot.enumpack.Role;
import lombok.Data;

@Data
public class UserVO {

    private Long id;
    private String password;
    private String name;
    private String email;
    private Gender gender;
    private Role role;

}
