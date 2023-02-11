package com.gamjaring.web.springboot.service;

import com.gamjaring.web.springboot.domain.ImgSetRepository;
import com.gamjaring.web.springboot.domain.Member;
import com.gamjaring.web.springboot.domain.ImgSet;
import com.gamjaring.web.springboot.enumpack.ImgCase;
import com.gamjaring.web.springboot.filecontrol.S3FileComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;

@Service
@Transactional
public class ImgServiceImpl implements ImgService {

    private final ImgSetRepository imgSetRepository;
    //    private final FileHandler fileHandler;
    private final S3FileComponent s3FileComponent;

    @Autowired
    public ImgServiceImpl(ImgSetRepository imgSetRepository, S3FileComponent s3FileComponent) {
        this.imgSetRepository = imgSetRepository;
        this.s3FileComponent = s3FileComponent;
    }

    @Override
    public Member addMemberImg(Member member, MultipartFile img, String email) throws Exception {
        //List<MemberImg> list = fileHandler.parseFileInfo(new ArrayList<>(Arrays.asList(img)));

        if (img.isEmpty()) {
            // TODO : 파일이 없을 땐 어떻게 해야할까.. 고민을 해보아야 할 것 예외처리 해야함
        }
        // 파일에 대해 DB에 저장하고 가지고 있을 것
        else{
            String dirName = email; //실제 저장되는 경로가 email 폴더
            String uploadImageUrl = (s3FileComponent.upload(new MultipartFile[] {img}, dirName, "self")).get(0);
            ImgSet imgSet = ImgSet.builder()
                    .imgCase(ImgCase.SELF)
                    .file_size(img.getSize())
                    .stored_file_path(uploadImageUrl)
                    .original_file_name(img.getOriginalFilename())
                    .build();
            imgSetRepository.save(imgSet);
//            memberRepository.joinMemberToImg(member.getEmail(), imgSet);
            imgSetRepository.joinMemberToImg(member, imgSet.getId());

        }
        return member;
    }

}