//관리자가 필요해지면 사용하기
package com.gamjaring.web.springboot.user;

//
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {

    MALE("GENDER_MALE", "남성"),
    FEMALE("GENDER_FEMALE", "여성");
    private final String key;
    private final String title;
}