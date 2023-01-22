package com.gamjaring.web.springboot.comment;


import com.gamjaring.web.springboot.domain.Member;
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
