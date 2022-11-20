
package com.gamjaring.web.springboot.user;

//import com.sun.javafx.beans.IDProperty;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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

    @Column
    private String email;



    @Column//(nullable = false)
    private boolean gender;

    @Column
    private String image;

//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private Role role;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Builder
    public User(String name){
        this.name=name;
        this.password=password;
    }

    public User update(String name, String password){
        this.name=name;
        this.password=password;
        return this;
    }
    public boolean isGender() {
        return gender;
    }
    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
