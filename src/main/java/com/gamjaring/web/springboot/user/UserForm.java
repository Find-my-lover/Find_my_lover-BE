//DTO다.
//계층 간의 데이터 교환을 담당하는 객체이다.
package com.gamjaring.web.springboot.user;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserForm {


    private String name;

    private String email;

    private String password;
    //private String email;


//    public String getGender() {
//        return gender;
//    }
//
//    public void setGender(String gender) {
//        this.gender = gender;
//    }

    //gender는 binary로 가고 싶은데 방법 고민중
    //private String gender;


//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }


}
