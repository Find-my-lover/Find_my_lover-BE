package com.gamjaring.web.springboot.controller;

import com.gamjaring.web.springboot.domain.*;
import com.gamjaring.web.springboot.dto.UserDto;
import com.gamjaring.web.springboot.enumpack.ImgCase;
import com.gamjaring.web.springboot.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.password.PasswordEncoder;

@RequiredArgsConstructor
class RingMyBellControllerTest {

    private final MemberRepository memberRepository;
    private final ImgSetRepository imgSetRepository;
    private final ResultsRepository resultsRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    //로그인하기위해 회원가입이 되어있는 유저를 미리 만들 수 있는 메서드 설정
    public Member createUser(String email, String password){
        UserDto userDto =new UserDto();
        userDto.setEmail(email);
        userDto.setName("name");
        userDto.setPassword(password);
        Member user=Member.createUser(userDto, passwordEncoder);
        return userService.createUser(user);
    }
//
//    @Test
//    void recommend() {
//        //given
////        @ApiOperation(value = "1차 결과 출력")
////        @GetMapping("/recommend")
////        public List<String> recommend(@Valid @RequestParam String email) {
////            Member member = userService.getUser(email);
////            return Arrays.asList(testService.getCouplePictureUrl(member), resultsSerivce.getPartnerName(member));
////        }
//        String email = "email@gmail.com";
//        String password = "password";
//        Member member = this.createUser(email, password);
//        memberRepository.save(member);
//        imgSetRepository.save(ImgSet.builder()
//                .imgCase(ImgCase.COUPLE)
//                .file_size(1234)
//                .original_file_name("original_file_name")
//                .stored_file_path("static/tmp")
//                .member(member)
//                .build());
//        resultsRepository.save(Results.builder()
//                .member(member)
//                .partner_name("partner")
//                .clothes_num(1)
//                .pose_num(1)
//                .build());
//        // TODO : 더 공부하고 다시 짜기...
//
//        //when
//
//        //then
//    }
}