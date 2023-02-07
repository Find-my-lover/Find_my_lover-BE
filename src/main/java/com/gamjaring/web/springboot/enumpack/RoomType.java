package com.gamjaring.web.springboot.enumpack;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum RoomType {
    LIVINGROOM("거실"),
    TOILET("화장실"),
    KITCHEN("부엌"),
    BEDROOM("침실"),
    VERANDA("베란다"),
    WAREHOUSE("창고");
    private final String value;
}
