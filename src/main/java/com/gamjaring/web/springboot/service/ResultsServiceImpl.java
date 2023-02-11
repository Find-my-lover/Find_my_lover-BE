package com.gamjaring.web.springboot.service;

import com.gamjaring.web.springboot.domain.*;
import com.gamjaring.web.springboot.dto.ResultsRequestDto;
import com.gamjaring.web.springboot.enumpack.ImgCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Transactional
@RequiredArgsConstructor
@Service
public class ResultsServiceImpl implements ResultsService{

    private final ResultsRepository resultsRepository;
    private final MemberRepository memberRepository;
    private final ImgSetRepository imgSetRepository;

    /* CREATE */
    public Long save(String email, ResultsRequestDto dto) {

        Member user = memberRepository.findByEmail(email);
//        dto.setUser(user);

        Results results = dto.toEntity();
        resultsRepository.save(results);

        // TODO : 파이썬과 통신해서 S3에 관련 사진들 넣기

        return results.getId();
    }

    @Override
    public List<String> getResultPictureUrl(Member member) {
        List<String> Urls = new ArrayList<>();
        // TODO : FINAL1 부터 FIANL6 까지 다 해야함
        ImgSet imgSet = imgSetRepository.findByImgCase(ImgCase.FINAL1);
        Urls.add(imgSet.getStored_file_path());
        return Urls;
    }

    @Override
    public List<String> getSelectPhotoListUrl(Member member) {
        // TODO : S3에 18장의 커플 사진들이 들어가 있어야 하고 그걸 꺼내와야 함
        List<String> Urls = new ArrayList<>();

        return Urls;
    }

    @Override
    public void changeCustom(int poseNum, int costumeNum) {
        //TODO : 커플 사진이 바뀌어야 하고 그에 따른 FINAL 사진들도 바뀌어야 함
    }

    @Override
    public String getPartnerName(Member member) {
        return resultsRepository.getResultsByMember(member).getPartner_name();
    }


}
