package com.gamjaring.web.springboot.controller;

import com.gamjaring.web.springboot.domain.Gender;
import com.gamjaring.web.springboot.domain.Member;
import com.gamjaring.web.springboot.service.MemberImgServiceImpl;
import com.gamjaring.web.springboot.filecontrol.S3Uploader;
import com.gamjaring.web.springboot.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;

@Api(tags={"Main"})
@RestController(value = "/main")
public class MainController {

    private final UserServiceImpl userServiceImpl;
    private final MemberImgServiceImpl memberImgServiceImpl;
    private final S3Uploader s3Uploader;

    @Autowired
    public MainController(UserServiceImpl userServiceImpl, MemberImgServiceImpl memberImgServiceImpl, S3Uploader s3Uploader) {
        this.userServiceImpl = userServiceImpl;
        this.memberImgServiceImpl = memberImgServiceImpl;
        this.s3Uploader = s3Uploader;
    }

    @ApiOperation(value = "결과화면")
    @PostMapping("/result")
    public ResponseEntity<?> select(@Valid @RequestParam String email,
                                    @Valid @RequestParam Gender gender,
                                    @Valid @RequestParam MultipartFile file) throws Exception {
        //email로 사용자를 찾고 gender를 최신화하고 image를 저장한다.
        Member member = userServiceImpl.getUser(email);
        userServiceImpl.updateGender(email, gender);
        memberImgServiceImpl.addMemberImg(member, file);
        return ResponseEntity.ok().build();
//        return ResponseEntity.ok(fileUploadService.save(file));
    }

    @ApiOperation(value = "업로드")
    @PostMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("data") MultipartFile multipartFile) throws IOException {
        return s3Uploader.upload(multipartFile, "static");
    }
}
