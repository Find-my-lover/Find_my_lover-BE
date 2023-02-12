package com.gamjaring.web.springboot.domain;


import com.gamjaring.web.springboot.enumpack.RoomType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Table(name = "room")
@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id")
    private Long id;

    @Column
    private RoomType roomType;

    @ManyToOne
    @JoinColumn(name = "results_id")
    private Results results;    //한개의 results에 여러개의 room

    @OneToMany(mappedBy = "room")
    private List<Present> present;

}
