//관리자가 필요해지면 사용하기
package com.gamjaring.web.springboot.user;

//
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {

    MALE("남성"),
    FEMALE("여성");
    private final String value;
}