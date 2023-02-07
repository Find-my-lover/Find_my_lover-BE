package com.gamjaring.web.springboot.dto;

import com.gamjaring.web.springboot.domain.Present;
import com.gamjaring.web.springboot.enumpack.PresentType;
import lombok.Builder;
import lombok.Getter;

@Getter
public class PresentResponseDto {
    private PresentType present_type;

    @Builder
    public PresentResponseDto(Present present) {
        this.present_type= present.getPresent_type();
    }

}
