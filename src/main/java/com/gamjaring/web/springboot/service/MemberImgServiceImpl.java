package com.gamjaring.web.springboot.service;

import com.gamjaring.web.springboot.domain.MemberImgRepository;
import com.gamjaring.web.springboot.domain.UserRepository;
import com.gamjaring.web.springboot.domain.Member;
import com.gamjaring.web.springboot.domain.MemberImg;
import com.gamjaring.web.springboot.filecontrol.FileHandler;
import com.gamjaring.web.springboot.filecontrol.S3Uploader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class MemberImgServiceImpl implements MemberImgService {

    private final UserRepository userRepository;
    private final MemberImgRepository memberImgRepository;
//    private final FileHandler fileHandler;
    private final S3Uploader s3Uploader;

    @Autowired
    public MemberImgServiceImpl(UserRepository userRepository, MemberImgRepository memberImgRepository, S3Uploader s3Uploader) {
        this.userRepository = userRepository;
        this.memberImgRepository = memberImgRepository;
        this.s3Uploader = s3Uploader;
    }

    @Override
    public Member addMemberImg(Member member, MultipartFile img) throws Exception{
        //List<MemberImg> list = fileHandler.parseFileInfo(new ArrayList<>(Arrays.asList(img)));;

        if(img.isEmpty()){
            // TODO : 파일이 없을 땐 어떻게 해야할까.. 고민을 해보아야 할 것
        }
        // 파일에 대해 DB에 저장하고 가지고 있을 것
        else{
            String dirName = "static"; //TODO : 실제 저장되는 경로로 바꿔야 한다.
            s3Uploader.upload(img, dirName);
            MemberImg memberImg = MemberImg.builder()
                    .file_size(img.getSize())
                    .stored_file_path(dirName)
                    .original_file_name(img.getOriginalFilename())
                    .build();
            memberImgRepository.save(memberImg);
            userRepository.joinMemberToImg(member.getEmail(), memberImg);
        }
        return member;
    }

}
