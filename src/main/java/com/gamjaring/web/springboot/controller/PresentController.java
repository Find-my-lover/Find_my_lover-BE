package com.gamjaring.web.springboot.controller;


import com.gamjaring.web.springboot.domain.Present;
import com.gamjaring.web.springboot.domain.PresentRepository;
import com.gamjaring.web.springboot.service.PresentService;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class PresentController {

    private  PresentService presentService;
    private PresentRepository presentRepository;

    public PresentController(PresentService presentService, PresentRepository presentRepository) {
        this.presentService = presentService;
        this.presentRepository = presentRepository;
    }

    //컨트롤러에서 데이터를 인자에 할당하는 두가지 방법 -> @RequestBody 와 @RequestParam
    //@RequestBody : 단지 ex : 'name=jun&age=13' 이라는 String 으로 전달되어 전달된 데이터를 사용하기에는 불편함
    //@RequestParm : 데이터를 받을때는 데이터를 저장하는 이름으로 메서드의 변수명을 설정

    //Request가 들어오는 타입에 따라받는 방법은 크게 4가지
    //1. URL 변수 (@PathVariable)
    //2. Query String (@RequestParam)
    //3. Body
    //4. Form
    //@PathVariable은

    //현재 내 집혼수 화면 상태를 보여주는 곳 -> get
    @ApiOperation(value = " 현재 내 집혼수 화면 상태")
    @GetMapping("/ringmybell/friends")
    public ResponseEntity<?> viewResult(Long id) {      //여기 물음표 해놔야 아래 오류가 안생김
        if (presentRepository.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(presentRepository.findById(id), HttpStatus.OK); // 이거 수정해야함
    }

    @PostMapping("/ringmybell/friends/comment")
    public ResponseEntity<?> giveCommentAndGift(@RequestParam Present present){
        presentService.createPresent(present);
        return ResponseEntity.ok().build();
    }





}
