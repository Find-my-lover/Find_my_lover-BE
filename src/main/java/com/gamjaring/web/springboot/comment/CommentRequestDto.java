package com.gamjaring.web.springboot.comment;

import com.gamjaring.web.springboot.user.User;

public class CommentRequestDto {
    private Long id;
    private String comment;
    private User user;

    /* Entity -> Dto*/
    public Comment toEntity() {
        Comment comments = Comment.builder()
                .id(id)
                .comment(comment)
                .user(user)
                .build();
        return comments;
    }

}
