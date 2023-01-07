package com.gamjaring.web.springboot.user;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class MemberImgServiceImpl implements MemberImgService{

    private final UserRepository userRepository;
    private final MemberImgRepository memberImgRepository;
    private final FileHandler fileHandler;

    public MemberImgServiceImpl(UserRepository userRepository, MemberImgRepository memberImgRepository) {
        this.userRepository = userRepository;
        this.memberImgRepository = memberImgRepository;
        this.fileHandler = new FileHandler();
    }

    @Override
    public Member addMemberImg(Member member, MultipartFile img) throws Exception{
        List<MemberImg> list = fileHandler.parseFileInfo(new ArrayList<>(Arrays.asList(img)));

        if(list.isEmpty()){
            // TODO : 파일이 없을 땐 어떻게 해야할까.. 고민을 해보아야 할 것
        }
        // 파일에 대해 DB에 저장하고 가지고 있을 것
        else{
            MemberImg memberImg = list.get(0);
            memberImgRepository.save(memberImg);
            userRepository.joinMemberToImg(member.getEmail(), memberImg);
        }
        return member;
    }

}
