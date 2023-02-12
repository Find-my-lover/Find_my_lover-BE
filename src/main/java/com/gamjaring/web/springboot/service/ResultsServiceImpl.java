package com.gamjaring.web.springboot.service;

import com.gamjaring.web.springboot.domain.*;
import com.gamjaring.web.springboot.dto.ResultsPictureListDto;
import com.gamjaring.web.springboot.dto.ResultsRequestDto;
import com.gamjaring.web.springboot.enumpack.ImgCase;
import com.gamjaring.web.springboot.filecontrol.S3FileComponent;
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
    private final S3FileComponent s3FileComponent;

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
    public List<String> getResultsPictureUrl(Member member) {   //내가 해야할 총 사진
        List<String> Urls = new ArrayList<>();
        // TODO : FINAL1 부터 FIANL6 까지 다 해야함
//        ImgSet imgSet = imgSetRepository.findByImgCase(ImgCase.FINAL1);
//        Urls.add(imgSet.getStored_file_path());
        return Urls;
    }

    @Override
    public List<ResultsPictureListDto> getResultsPictureList(Member member) {
        // TODO : S3에 18장의 커플 사진들이 들어가 있어야 하고 그걸 꺼내와야 함
        List<String> fileNames = new ArrayList<>();
        for (int i = 1; i <= 3; i++)
            for (int j = 1; j <= 6; j++)
                fileNames.add("couple" + i + j);
        List<String> urls = s3FileComponent.getUrls(member.getEmail(), fileNames);

        if (urls.size() < 18) return null; //TODO : 예외처리 해야함. 커플 사진들 다 안올라옴.

        List<ResultsPictureListDto> dtos = new ArrayList<>();
        for (int i = 0; i < 18; i++) {
            dtos.add(ResultsPictureListDto.builder()
                    .url(urls.get(i))
                    .pose_num(i/6+1)
                    .clothes_num(i%6+1)
                    .build());
        }
        return dtos;
    }

    @Override
    public void changeCustom(Member member, int poseNum, int costumeNum) {
        // TODO : poseNum, clothesNum 바꾸고 그에 따른 FINAL 사진들도 바뀌어야 함
    }

    @Override
    public String getPartnerName(Member member) {
        return resultsRepository.getResultsByMember(member).getPartnerName();
    }




}
