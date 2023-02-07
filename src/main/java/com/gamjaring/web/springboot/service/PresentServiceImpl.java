package com.gamjaring.web.springboot.service;

import com.gamjaring.web.springboot.domain.Member;
import com.gamjaring.web.springboot.domain.MemberRepository;
import com.gamjaring.web.springboot.domain.Present;
import com.gamjaring.web.springboot.domain.PresentRepository;
import com.gamjaring.web.springboot.dto.PresentRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class PresentServiceImpl implements PresentService {
    @Autowired
    private final PresentRepository presentRepository;
    @Autowired
    private final MemberRepository memberRepository;

    public PresentServiceImpl(PresentRepository presentRepository, MemberRepository memberRepository) {
        this.presentRepository = presentRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    @Override
    public Present createPresent(Present present){
        return presentRepository.save(present);
    }

    public Member getMember(Long member_id) {
        return memberRepository.findById(member_id)
                .orElseThrow(() -> new IllegalArgumentException("없는 멤버입니다."));
    }


    @Transactional
    public void modify(String writer, Long present_id, PresentRequestDto request, Long member_id) {

        Member member = getMember(member_id);

        Present present = validateReply(writer, present_id, member);
        present.modify(request.getMessage());
        return;
    }

    @Transactional
    @Override
    public Present validateReply(String writer, Long present_id, Member member){
        Present present = presentRepository.findById(present_id)
                .orElseThrow(() -> new RuntimeException("선물이 없습니다"));

        return present;
    }


}
