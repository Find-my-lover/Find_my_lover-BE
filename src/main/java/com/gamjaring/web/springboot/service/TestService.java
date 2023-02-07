package com.gamjaring.web.springboot.service;

import com.gamjaring.web.springboot.domain.Member;
import com.gamjaring.web.springboot.enumpack.Gender;
import org.springframework.web.multipart.MultipartFile;

public interface TestService {
    void testLover(String email, Gender gender, MultipartFile file) throws Exception;

    String getCouplePictureUrl(Member member);

    boolean checkExist(Member member);
}
