package com.gamjaring.web.springboot.service;

import com.gamjaring.web.springboot.dto.ResultsRequestDto;

public interface ResultsService {
    public Long save(String email, ResultsRequestDto dto);
}
