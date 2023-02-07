package com.gamjaring.web.springboot.service;

import com.gamjaring.web.springboot.domain.ImgSet;
import com.gamjaring.web.springboot.domain.ImgSetRepository;
import com.gamjaring.web.springboot.domain.Member;
import com.gamjaring.web.springboot.enumpack.Gender;
import com.gamjaring.web.springboot.enumpack.ImgCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
@Transactional
public class TestServiceImpl implements TestService {

   private final UserServiceImpl userServiceImpl;
   private final ImgServiceImpl imgServiceImpl;
    private final ImgSetRepository imgSetRepository;

    @Override
    public void testLover(String email, Gender gender, MultipartFile file) throws Exception{
        Member member = userServiceImpl.getUser(email);
        userServiceImpl.updateGender(email, gender);
        imgServiceImpl.addMemberImg(member, file, email);
        // TODO : flask 서버에 요청 보내기. 응답이 올 때까지 기다릴 수 있으면 기다리고 안된다면 다시 요청받기

    }

    @Override
    public String getCouplePictureUrl(Member member) {
        ImgSet imgSet = imgSetRepository.findByImgCase(ImgCase.COUPLE);
        return imgSet.getStored_file_path();
    }

    @Override
    public boolean checkExist(Member member) {
        // TODO : 이 사람이 전에 테스트한 결과가 있으면 DB와 S3에서 모두 삭제
        return false;
    }
}
