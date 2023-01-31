package com.gamjaring.web.springboot.service;

import com.gamjaring.web.springboot.domain.Comment;
import com.gamjaring.web.springboot.domain.CommentRepository;
import com.gamjaring.web.springboot.domain.Results;
import com.gamjaring.web.springboot.domain.ResultsRepository;
import com.gamjaring.web.springboot.domain.Member;
import com.gamjaring.web.springboot.domain.MemberRepository;
import com.gamjaring.web.springboot.dto.CommentRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final MemberRepository memberRepository;
    private final ResultsRepository resultsRepository;

    /* CREATE */
    @Transactional
    public Long commentSave(String email, Long id, CommentRequestDto dto) {
        Member member = memberRepository.findByEmail(email);
        Results results = resultsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("코멘트 작성 실패: 해당 결과페이지가 존재하지 않습니다." + id));

        dto.setResults(results);

        Comment comment = dto.toEntity();
        commentRepository.save(comment);

        return dto.getId();
    }
}