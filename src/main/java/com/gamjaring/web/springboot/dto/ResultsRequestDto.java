package com.gamjaring.web.springboot.dto;


import com.gamjaring.web.springboot.domain.Results;
import com.gamjaring.web.springboot.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResultsRequestDto {
    private Long id;

    private Member user;

    /* Dto -> Entity */
    public Results toEntity() {
        Results results = Results.builder()
                .id(id)
                .user(user)
                .build();
        return results;
    }

}
