package com.gamjaring.web.springboot.comment;

import com.gamjaring.web.springboot.domain.Member;
import com.gamjaring.web.springboot.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service
public class ResultsSerivce {

    private final ResultsRepository resultsRepository;

    private final UserRepository userRepository;

    /* CREATE */
    @Transactional
    public Long save(String email, ResultsRequestDto dto) {

        Member user = userRepository.findByEmail(email);
        dto.setUser(user);

        Results results = dto.toEntity();
        resultsRepository.save(results);

        return results.getId();
    }


}
