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
public class PresentRequestDto {
    private PresentType present_type;


    public Present toEntity() {
        Present present = Present.builder()
                .present_type(present_type)
                .build();
        return present;
    }
}
