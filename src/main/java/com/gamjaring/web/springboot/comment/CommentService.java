package com.gamjaring.web.springboot.comment;



import com.gamjaring.web.springboot.domain.Member;
import com.gamjaring.web.springboot.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final ResultsRepository resultsRepository;

    /* CREATE */
    @Transactional
    public Long commentSave(String email, Long id, CommentRequestDto dto) {
        Member user = userRepository.findByEmail(email);
        Results results = resultsRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("코멘트 작성 실패: 해당 결과페이지가 존재하지 않습니다." + id));

        dto.setResults(results);

        Comment comment = dto.toEntity();
        commentRepository.save(comment);

        return dto.getId();
    }
}