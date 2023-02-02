package com.gamjaring.web.springboot.service;

import com.gamjaring.web.springboot.domain.MemberImgRepository;
import com.gamjaring.web.springboot.domain.UserRepository;
import com.gamjaring.web.springboot.domain.Member;
import com.gamjaring.web.springboot.domain.MemberImg;
import com.gamjaring.web.springboot.filecontrol.S3FileComponent;
import com.gamjaring.web.springboot.user.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.multipart.MultipartFile;
import javax.transaction.Transactional;

@Service
@Transactional
public class MemberImgServiceImpl implements MemberImgService {

    private final UserRepository userRepository;
    private final MemberImgRepository memberImgRepository;
//    private final FileHandler fileHandler;
    private final S3FileComponent s3FileComponent;


    @Autowired
    public MemberImgServiceImpl(UserRepository userRepository, MemberImgRepository memberImgRepository, S3FileComponent s3FileComponent
                                ) {
        this.userRepository = userRepository;
        this.memberImgRepository = memberImgRepository;
        this.s3FileComponent = s3FileComponent;
    }

    @Override
    public Member addMemberImg(Member member, MultipartFile img, SecurityContext context) throws Exception {
        //List<MemberImg> list = fileHandler.parseFileInfo(new ArrayList<>(Arrays.asList(img)));;
        Authentication authentication=context.getAuthentication();
        CustomUserDetails details=(CustomUserDetails) authentication.getPrincipal();
        if (img.isEmpty()) {
            // TODO : 파일이 없을 땐 어떻게 해야할까.. 고민을 해보아야 할 것 예외처리 해야함
        }
        // 파일에 대해 DB에 저장하고 가지고 있을 것
        else{
            String dirName = details.getUsername(); //실제 저장되는 경로가 email 폴더
            String uploadImageUrl = (s3FileComponent.upload(new MultipartFile[] {img}, dirName, "self")).get(0);
            MemberImg memberImg = MemberImg.builder()
                    .file_size(img.getSize())
                    .stored_file_path(uploadImageUrl)
                    .original_file_name(img.getOriginalFilename())
                    .build();
            memberImgRepository.save(memberImg);
            userRepository.joinMemberToImg(member.getEmail(), memberImg);
        }
        return member;
    }

}
