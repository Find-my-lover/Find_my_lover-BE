package com.gamjaring.web.springboot.dto;

import com.gamjaring.web.springboot.domain.Present;
import com.gamjaring.web.springboot.enumpack.PresentType;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class PresentResponseDto {   //대답해 주는 것
    private PresentType present_type;
    private String writer;
    private String message;

    @Builder
    public PresentResponseDto(Present present) {
        this.present_type= present.getPresent_type();
        this.writer = present.getWriter();
        this.message = present.getMessage();
    }

}
