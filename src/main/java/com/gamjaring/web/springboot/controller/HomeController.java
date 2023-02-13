package com.gamjaring.web.springboot.controller;

import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


//매핑만 하고 현재까지는 경로지정은 없음
@Api(tags={"home"})
@RestController
public class HomeController {

//    @CrossOrigin("*")
    @GetMapping("/")
    public String home(){
        return "home";
    }

//    @GetMapping("/test")
//    public List<ResultsPictureListDto> test() {
//        return Arrays.asList(ResultsPictureListDto.builder()
//                .url("url")
//                .clothes_num(1)
//                .pose_num(1)
//                .build(),
//                ResultsPictureListDto.builder()
//                        .url("url2")
//                        .pose_num(2)
//                        .clothes_num(2)
//                        .build());
//    }
}
