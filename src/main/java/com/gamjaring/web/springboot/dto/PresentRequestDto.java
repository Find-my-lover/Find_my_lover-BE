package com.gamjaring.web.springboot.dto;

import com.gamjaring.web.springboot.domain.Present;
import com.gamjaring.web.springboot.enumpack.PresentType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PresentRequestDto {    //요청으로 부터 정보를 받아 DB에 저장할 때
    private PresentType present_type;
    private String writer;
    private String message;



    public Present toEntity() {
        Present present = Present.builder()
                .present_type(present_type)
                .writer(writer)
                .message(message)
                .build();
        return present;
    }
}
