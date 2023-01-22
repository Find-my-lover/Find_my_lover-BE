package com.gamjaring.web.springboot.comment;


public class CommentResponseDto {
    private Long id;
    private String content;
    private Long resultsId;

    /* Entity -> Dto*/
    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.resultsId = comment.getResults().getId();
    }
}
