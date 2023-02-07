package com.gamjaring.web.springboot.dto;

import com.gamjaring.web.springboot.domain.Results;
import com.gamjaring.web.springboot.domain.Room;
import com.gamjaring.web.springboot.enumpack.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomRequestDto {
    private RoomType roomType;

    public Room toEntity() {
        Room room = Room.builder()
                .roomType(roomType)
                .build();
        return room;
    }


}
