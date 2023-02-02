package com.gamjaring.web.springboot.service;

import com.gamjaring.web.springboot.domain.Member;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.multipart.MultipartFile;

public interface MemberImgService {
    Member addMemberImg(Member member, MultipartFile img, SecurityContext context) throws Exception;
}
