package com.gamjaring.web.springboot.dto;


import com.gamjaring.web.springboot.domain.Comment;
import com.gamjaring.web.springboot.domain.Results;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentRequestDto {
    private Long id;
    private String content;
    private Results results;


    /* Entity -> Dto*/
    public Comment toEntity() {
        Comment comments = Comment.builder()
                .id(id)
                .content(content)
                .results(results)
                .build();
        return comments;
    }

}