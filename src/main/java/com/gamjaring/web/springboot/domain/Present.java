package com.gamjaring.web.springboot.domain;


import com.gamjaring.web.springboot.enumpack.PresentType;
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
@Table(name = "present")
public class Present {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "present_id")
    private Long id;

    @Column
    private PresentType presentType;

    @Column
    private String writer;

    @Column
    private String message;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "room_id")
    private Room room;    //한개의 comment에 여러개의 present

    public void modify(String content) {
        this.message = message;
    }
}
