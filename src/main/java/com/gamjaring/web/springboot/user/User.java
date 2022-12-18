//회원 정보를 저장하는 User Entity입니다.
//DB테이블과 1:1로 매핑되며 테이블이 가지지 않는 컬럼을 필드로 가져서는 안된다!!
//서비스 클래스들과 비지니스 로직들은 이 클래스를 기준으로 동작

package com.gamjaring.web.springboot.user;

//import com.sun.javafx.beans.IDProperty;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;

@Getter
@Setter
@Table(name="user")
@Entity
public class User{


    @Id
    //@Column(name="user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String password;

    private String name;

    @Column(unique = true)
    private String email;

    //user Entity를 이렇게 생성
    public static User createUser(UserForm userForm, PasswordEncoder passwordEncoder){
        User user=new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());

        //패스워드는 처리를 해주자.
        String password=passwordEncoder.encode(userForm.getPassword());
        user.setPassword(password);

        return user;
    }
//
//    @Column(nullable = false)
//    private String gender;

//    @Column
//    private String picture;

//    @Enumerated(EnumType.STRING)
//    @Column(nullable = false)
//    private Role role;



/*
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
*/
}
