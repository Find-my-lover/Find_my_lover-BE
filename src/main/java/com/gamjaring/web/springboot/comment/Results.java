package com.gamjaring.web.springboot.comment;

import com.gamjaring.web.springboot.user.Member;
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

    private String writer;

    @ManyToOne(fetch = FetchType.LAZY)  //한개의 user에 여러개의 results
    @JoinColumn(name = "user_id")
    private Member user;

    @OneToMany(mappedBy = "results", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
    @OrderBy("id asc") // 코멘트 정렬
    private List<Comment> comments;


}