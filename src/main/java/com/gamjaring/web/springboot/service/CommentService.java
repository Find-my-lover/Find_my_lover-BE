package com.gamjaring.web.springboot.service;

import com.gamjaring.web.springboot.dto.CommentRequestDto;

public interface CommentService {
    public Long commentSave(String email, Long id, CommentRequestDto dto);
}
