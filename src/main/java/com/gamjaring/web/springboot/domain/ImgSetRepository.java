package com.gamjaring.web.springboot.domain;

import com.gamjaring.web.springboot.enumpack.ImgCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ImgSetRepository extends JpaRepository<ImgSet, Long> {

//    @Modifying(clearAutomatically = true)
//    @Query("UPDATE Member m SET m.imgSet=:imgSet WHERE m.email=:email")
//    void  joinMemberToImg(String email, ImgSet imgSet);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE ImgSet i SET i.member=:member WHERE i.id=:id")
    void  joinMemberToImg(Member member, Long id);

    ImgSet findByImgCase(ImgCase imgCase);
}
