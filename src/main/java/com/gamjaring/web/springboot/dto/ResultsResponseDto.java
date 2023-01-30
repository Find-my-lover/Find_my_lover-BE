package com.gamjaring.web.springboot.dto;


import com.gamjaring.web.springboot.domain.Results;

import java.util.List;
import java.util.stream.Collectors;

/**
 * results 정보를 리턴할 응답(Response) 클래스
 * Entity 클래스를 생성자 파라미터로 받아 데이터를 Dto로 변환하여 응답
 * 별도의 전달 객체를 활용해 연관관계를 맺은 엔티티간의 무한참조를 방지
 */
public class ResultsResponseDto {

    private Long id;

    private Long userId;
    private List<CommentResponseDto> comments;

    /* Entity -> Dto*/
    public ResultsResponseDto(Results results) {
        this.id = results.getId();
        this.userId = results.getUser().getId();
        this.comments = results.getComments().stream().map(CommentResponseDto::new).collect(Collectors.toList());
    }
}
