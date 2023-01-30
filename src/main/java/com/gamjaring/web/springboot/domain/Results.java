package com.gamjaring.web.springboot.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Results  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "results_id")
    private Long id;

    //이미지 속성 추가해야함


    @ManyToOne(fetch = FetchType.LAZY)  //한개의 user에 여러개의 results
    @JoinColumn(name = "user_id")
    private Member user;


    @OneToMany(mappedBy = "results", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @OrderBy("id asc") // 코멘트 정렬
    private List<Comment> comments;


}