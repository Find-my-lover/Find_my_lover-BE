package com.gamjaring.web.springboot.dto;

import com.gamjaring.web.springboot.domain.Present;
import com.gamjaring.web.springboot.enumpack.PresentType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PresentResponseDto {   //대답해 주는 것
    private final PresentType present_type;
    private final String writer;
    private final String message;

    @Builder
    public PresentResponseDto(Present present) {
        this.present_type= present.getPresentType();
        this.writer = present.getWriter();
        this.message = present.getMessage();
    }

}
