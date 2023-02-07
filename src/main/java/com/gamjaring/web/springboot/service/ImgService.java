package com.gamjaring.web.springboot.service;

import com.gamjaring.web.springboot.domain.Member;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.multipart.MultipartFile;

<<<<<<< HEAD:src/main/java/com/gamjaring/web/springboot/service/MemberImgService.java
public interface MemberImgService {
    Member addMemberImg(Member member, MultipartFile img, SecurityContext context) throws Exception;
=======
public interface ImgService {
    Member addMemberImg(Member member, MultipartFile img, String email) throws Exception;
>>>>>>> 4257d155af5627df540f293adf5178f39f16d3ac:src/main/java/com/gamjaring/web/springboot/service/ImgService.java
}
