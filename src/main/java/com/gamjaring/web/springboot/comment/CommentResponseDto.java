package com.gamjaring.web.springboot.comment;

import com.gamjaring.web.springboot.user.User;

public class CommentResponseDto {
    private Long id;
    private String comment;
    private User user;
    private Long resultsId;

    /* Entity -> Dto*/
    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.resultsId = comment.getResults().getId();
    }
}
