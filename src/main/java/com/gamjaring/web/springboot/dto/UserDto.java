//DTO다.
//계층 간의 데이터 교환을 담당하는 객체이다.
package com.gamjaring.web.springboot.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Setter
@Getter
public class UserDto {

    @NotBlank(message="닉네임을 입력해주세요")
    private String name;

    //email이 pk인가?
    @NotBlank(message = "이메일을 입력해주세요")
    @Email(message = "이메일 형식으로 작성해주세요.")
    private String email;

    @NotBlank(message = "비밀번호를 입력해주세요")
    @Length(min=8, max=16, message = "비밀번호는 8자 이상 16자 이하로 입력해주세요.")
    private String password;

}
