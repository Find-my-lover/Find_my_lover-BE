package com.gamjaring.web.springboot.dto;


import com.gamjaring.web.springboot.domain.Room;
import com.gamjaring.web.springboot.enumpack.RoomType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class RoomResponseDto {
    private RoomType roomType;

    @Builder
    public RoomResponseDto(Room room) {
        this.roomType= room.getRoomType();

    }

}
