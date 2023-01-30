package com.gamjaring.web.springboot.controller;

import com.gamjaring.web.springboot.domain.Gender;
import com.gamjaring.web.springboot.domain.Member;
import com.gamjaring.web.springboot.filecontrol.S3FileComponent;
import com.gamjaring.web.springboot.service.MemberImgServiceImpl;
import com.gamjaring.web.springboot.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@Api(tags={"ringmybell"})
@RestController(value = "/main")
@RequestMapping("/ringmybell")
@RequiredArgsConstructor
public class RingMyBellController {

    private final UserServiceImpl userServiceImpl;
    private final MemberImgServiceImpl memberImgServiceImpl;
    private final S3FileComponent s3FileComponent;


    @ApiOperation(value = "테스트실행")
    @PostMapping("/test")
    public ResponseEntity<?> select(@Valid @RequestParam String email,
                                    @Valid @RequestParam Gender gender,
                                    @Valid @RequestParam MultipartFile file) throws Exception {
        //email로 사용자를 찾고 gender를 최신화하고 image를 저장한다.
        Member member = userServiceImpl.getUser(email);
        userServiceImpl.updateGender(email, gender);
        memberImgServiceImpl.addMemberImg(member, file, email);
        return ResponseEntity.ok().build();
    }

    @ApiOperation(value = "다운로드테스트")
    @GetMapping("/download")
    public ResponseEntity<?> download(@RequestParam String filePath) throws IOException {
        return s3FileComponent.download(filePath);
    }
}
