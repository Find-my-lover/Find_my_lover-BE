package com.gamjaring.web.springboot.controller;

import com.gamjaring.web.springboot.domain.Gender;
import com.gamjaring.web.springboot.domain.Member;
import com.gamjaring.web.springboot.service.FileUploadService;
import com.gamjaring.web.springboot.service.MemberImgServiceImpl;
import com.gamjaring.web.springboot.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Api(tags={"Main"})
@RestController(value = "/main")
public class MainController {

    private final UserServiceImpl userServiceImpl;
    private final MemberImgServiceImpl memberImgServiceImpl;
    private final FileUploadService fileUploadService;
    @Autowired
    public MainController(UserServiceImpl userServiceImpl, MemberImgServiceImpl memberImgServiceImpl, FileUploadService fileUploadService) {
        this.userServiceImpl = userServiceImpl;
        this.memberImgServiceImpl = memberImgServiceImpl;
        this.fileUploadService = fileUploadService;
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
        //return ResponseEntity.ok(fileUploadService.save(file));
    }
}
