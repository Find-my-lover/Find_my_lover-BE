package com.gamjaring.web.springboot.dto;


import com.gamjaring.web.springboot.domain.Member;
import com.gamjaring.web.springboot.domain.Results;
import lombok.Builder;
import lombok.Getter;


@Getter
public class ResultsResponseDto {

    private final Member member;
    private final String partner_name;
    private final int pose_num;
    private final int clothes_num;


    /* Entity -> Dto*/
    @Builder
    public ResultsResponseDto(Results results) {
        this.member= results.getMember();
        this.partner_name = results.getPartnerName();
        this.pose_num = results.getPoseNum();
        this.clothes_num = results.getClothesNum();

    }
}
//this.comments = results.getComments().stream().map(CommentResponseDto::new).collect(Collectors.toList());
//아까워서 냅둠