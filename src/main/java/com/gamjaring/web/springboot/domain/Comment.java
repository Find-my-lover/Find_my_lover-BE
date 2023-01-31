package com.gamjaring.web.springboot.domain;



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
    @Column(name = "comment_id")
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String message; // 코멘트 내용 구 content

    @Column
    private int present_num;    //이미지 번호 선택


    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;    //한개의 room에 여러개의 comment


}
