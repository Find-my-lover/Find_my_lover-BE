package com.gamjaring.web.springboot.comment;

import com.gamjaring.web.springboot.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "comments")
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String comment; // 코멘트 내용

    @ManyToOne
    @JoinColumn(name = "results_id")
    private Results results;    //한개의 결과에 여러개의 코멘트

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user; // 작성자
}
