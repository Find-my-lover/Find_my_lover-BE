package com.gamjaring.web.springboot.service;


import com.gamjaring.web.springboot.domain.Member;
import com.gamjaring.web.springboot.domain.Present;
import com.gamjaring.web.springboot.dto.PresentRequestDto;
import com.gamjaring.web.springboot.dto.PresentResponseDto;

import java.util.List;

public interface PresentService {
    Present createPresent(Present present);
    Member getMember(Long member_id);
    void modify(String writer, Long present_id, PresentRequestDto request, Long member_id);
    Present validateReply(String writer, Long present_id, Member member);

    List<PresentResponseDto> getPresentList(Member member);
}
