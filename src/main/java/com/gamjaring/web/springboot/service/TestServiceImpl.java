package com.gamjaring.web.springboot.service;

import com.gamjaring.web.springboot.domain.*;
import com.gamjaring.web.springboot.enumpack.Gender;
import com.gamjaring.web.springboot.filecontrol.S3FileComponent;
import com.gamjaring.web.springboot.httpconnection.HttpConn;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;

@RequiredArgsConstructor
@Service
@Transactional
public class TestServiceImpl implements TestService {

    private final UserService userService;
    private final ImgService imgService;
    private final ResultsRepository resultsRepository;
    private final S3FileComponent s3FileComponent;

    @Override
    public String testLover(String email, Gender gender, MultipartFile file) throws Exception{
        Member member = userService.getUser(email);
        userService.updateGender(email, gender);
        imgService.addMemberImg(member, file, email);

        Results results = Results.builder()
                .pose_num(1)
                .clothes_num(1)
                .partner_name("default")
                .build();

        resultsRepository.joinMemberToResults(member, results.getId());

        // flask 서버에 요청 보내기. 응답이 올 때까지 기다릴 수 있으면 기다리고 안된다면 다시 요청받기
        // TODO : 이 때 파트너 이름 받아와야 함
        return HttpConn.httpConnPost("http://127.0.0.1:5000/test", "test" + results.getId());

    }

    @Override
    public String getCouplePictureUrl(Member member) {
        //밑 주석 처럼 되려면 S3에 flask가 사진을 삽입할 때마다 그 정보를 백엔드로 보내줘서 데이터베이스에 삽입해야 한다.
        //굳이..? 그냥 S3에 있는지 검사하고 가져오는 게 나을 듯
        //그니까 사실상 데이터베이스에 들어가는 사진 정보는 사용자 사진밖에 없다는 거
//        ImgSet imgSet = imgSetRepository.findByImgCase(ImgCase.COUPLE);
//        return imgSet.getStored_file_path();

        // S3에 "couple"+results.getId() 이름의 사진이 있으면 그 url을 응답. TODO : 아니면 예외처리
        return s3FileComponent.getUrls(member.getEmail(), new ArrayList<>(Arrays.asList("couple"+member.getResults().getId()))).get(0);
    }

    @Override
    public boolean checkExist(Member member) {
        // TODO : 이 사람이 전에 테스트한 결과가 있으면 DB와 S3에서 모두 삭제
        return false;
    }
}
