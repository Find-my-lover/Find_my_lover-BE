package com.gamjaring.web.springboot.service;

import com.gamjaring.web.springboot.domain.Member;
import com.gamjaring.web.springboot.dto.ResultsPictureListDto;
import com.gamjaring.web.springboot.dto.ResultsRequestDto;

import java.util.List;

public interface ResultsService {
    Long save(String email, ResultsRequestDto dto);

    List<String> getResultsPictureUrl(Member member);

    List<ResultsPictureListDto> getResultsPictureList(Member member);

    void changeCustom(Member member, int poseNum, int costumeNum);

    String getPartnerName(Member member);
}
