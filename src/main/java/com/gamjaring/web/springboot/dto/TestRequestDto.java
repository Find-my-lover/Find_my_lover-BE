package com.gamjaring.web.springboot.dto;

import com.gamjaring.web.springboot.enumpack.Gender;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TestRequestDto {

    private String email; // 나중에 없애고 일단 넣어놓자

    @NotBlank
    private Gender gender;

    @NotBlank
    private MultipartFile multipartFile;


}
