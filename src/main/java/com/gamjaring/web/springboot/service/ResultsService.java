package com.gamjaring.web.springboot.service;

import com.gamjaring.web.springboot.domain.Member;
import com.gamjaring.web.springboot.dto.ResultsRequestDto;

import java.util.List;

public interface ResultsService {
    Long save(String email, ResultsRequestDto dto);

    List<String> getResultPictureUrl(Member member);

    List<String> getSelectPhotoListUrl(Member member);

    void changeCustom(int poseNum, int costumeNum);

    String getPartnerName(Member member);
}
