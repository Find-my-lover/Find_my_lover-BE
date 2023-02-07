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

    private Member member;
    private String partner_name;
    private int pose_num;
    private int clothes_num;


    /* Dto -> Entity */
    public Results toEntity() {
        Results results = Results.builder()
                .member(member)
                .partner_name(partner_name)
                .pose_num(pose_num)
                .clothes_num(clothes_num)
                .build();
        return results;
    }

}
