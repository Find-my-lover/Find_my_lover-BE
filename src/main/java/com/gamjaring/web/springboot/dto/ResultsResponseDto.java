package com.gamjaring.web.springboot.dto;


import com.gamjaring.web.springboot.domain.Member;
import com.gamjaring.web.springboot.domain.Results;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.Column;
import java.util.List;
import java.util.stream.Collectors;

@Builder
@Getter
public class ResultsResponseDto {

    private Member member;
    private String partner_name;
    private int pose_num;
    private int clothes_num;


    /* Entity -> Dto*/
    @Builder
    public ResultsResponseDto(Results results) {
        this.member= results.getMember();
        this.partner_name = results.getPartner_name();
        this.pose_num = results.getPose_num();
        this.clothes_num = results.getClothes_num();

    }
}
//this.comments = results.getComments().stream().map(CommentResponseDto::new).collect(Collectors.toList());
//아까워서 냅둠