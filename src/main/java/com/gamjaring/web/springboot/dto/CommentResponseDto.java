package com.gamjaring.web.springboot.dto;


import com.gamjaring.web.springboot.domain.Comment;

public class CommentResponseDto {
    private Long id;
    private String message;
    private Long present_num;

    /* Entity -> Dto*/
    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.message = comment.getMessage();
        //this.present_num = comment.getPresent_num().getId(); -> 이거 해결해주세요 ㅠ -> user단에서 이거 처리하는지 확인좀 부탁

    }
}
