package com.gamjaring.web.springboot.user;

import org.springframework.web.multipart.MultipartFile;

public interface MemberImgService {
    Member addMemberImg(Member member, MultipartFile img) throws Exception;
}
