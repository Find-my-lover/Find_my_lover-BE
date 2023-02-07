//관리자가 필요해지면 사용하기
package com.gamjaring.web.springboot.enumpack;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Gender {

    MALE("남성"),
    FEMALE("여성");
    private final String value;

//    @JsonCreator
//    public static Gender from(String value) {
//        for (Gender status : Gender.values()) {
//            if (status.getValue().equals(value)) {
//                return status;
//            }
//        }
//        return null;
//    }
//
//    @JsonValue
//    public String getValue() {
//        return value;
//    }
}