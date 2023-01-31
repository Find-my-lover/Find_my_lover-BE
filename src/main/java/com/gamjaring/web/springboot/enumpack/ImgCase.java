package com.gamjaring.web.springboot.enumpack;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ImgCase {
    SELF("자신"),
    COUPLE("커플"),
    FINAL1("방1"),
    FINAL2("방2"),
    FINAL3("방3"),
    FINAL4("방4"),
    FINAL5("방5"),
    FINAL6("방6");
    private final String value;
}
