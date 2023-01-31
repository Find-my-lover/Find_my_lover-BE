package com.gamjaring.web.springboot.domain;


import com.gamjaring.web.springboot.enumpack.PresentType;
import com.gamjaring.web.springboot.enumpack.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
public class Present {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "present_id")
    private Long id;

    @Column
    private PresentType present_type;

    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Comment comment;    //한개의 comment에 여러개의 present



}
