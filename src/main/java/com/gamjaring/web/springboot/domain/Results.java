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

    @OneToOne //한개의 user에 한개의 results
    @JoinColumn(name = "user_id")
    private Member member;

    @Column
    private String partner_name;

    @Column
    private int pose_num;

    @Column
    private int clothes_num;

    @OneToMany(mappedBy = "results")
    private List<Room> room;

}