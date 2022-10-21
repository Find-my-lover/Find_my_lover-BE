
package com.gamjaring.web.springboot.user;

//import com.sun.javafx.beans.IDProperty;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Table(name="user")
@Entity
public class User{


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String password;

    @Column(nullable=false)
    private String name;
//
//    @Column
//    private String email;
//
//    @Column(nullable = false)
//    private String gender;

//    @Column
//    private String picture;

//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private Role role;


    @Builder
    public User(String name, String password){
        this.name=name;
        this.password=password;
    }

    public User update(String name, String password){
        this.name=name;
        this.password=password;
        return this;
    }

}
