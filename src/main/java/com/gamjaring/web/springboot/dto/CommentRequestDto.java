package com.gamjaring.web.springboot.dto;


import com.gamjaring.web.springboot.domain.Comment;
import com.gamjaring.web.springboot.domain.Results;
import com.gamjaring.web.springboot.domain.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequestDto {
    private String message;
    private Room room;


    /* Entity -> Dto*/
    public Comment toEntity() {
        Comment comments = Comment.builder()
                .message(message)
                .room(room)
                .build();
        return comments;
    }
}
