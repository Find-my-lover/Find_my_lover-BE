//엔터티를 데이터 베이스에 저장
package com.gamjaring.web.springboot.domain;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface UserRepository extends JpaRepository<Member, Long> {
    Member findByEmail(String email);

    @Modifying(clearAutomatically=true)
    @Query("UPDATE Member m SET m.gender=:gender WHERE m.email=:email")
    void updateGender(String email, Gender gender);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Member m SET m.memberImg=:memberImg WHERE m.email=:email")
    void  joinMemberToImg(String email, MemberImg memberImg);
}
