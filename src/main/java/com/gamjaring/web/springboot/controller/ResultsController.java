package com.gamjaring.web.springboot.controller;


import com.gamjaring.web.springboot.domain.Member;
import com.gamjaring.web.springboot.domain.PresentRepository;
import com.gamjaring.web.springboot.domain.ResultsRepository;
import com.gamjaring.web.springboot.dto.PresentRequestDto;
import com.gamjaring.web.springboot.dto.PresentResponseDto;
import com.gamjaring.web.springboot.dto.ResultsPictureListDto;
import com.gamjaring.web.springboot.service.PresentService;
import com.gamjaring.web.springboot.service.ResultsService;
import com.gamjaring.web.springboot.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class ResultsController {

    private final UserService userService;
    private final ResultsService resultsService;
    private final PresentService presentService;
    /*
    @ApiOperation(value = " 현재 내 집혼수 화면 상태")
    @GetMapping("/ringmybell/results")
        public ResponseEntity<?> viewResult(Long id) {

        if (resultsRepository.findById(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(resultsRepository.findById(id), HttpStatus.OK);
    }
    */


    @ApiOperation(value = "결과를 포함한 방 상태 보여주는 화면")
    @GetMapping("/ringmybell/results")
    public List<?> viewResult(String email){
        Member member = userService.getUser(email);
        List<ResultsPictureListDto> result_image = resultsService.getResultsPictureList(member);
        List<PresentResponseDto> presents = presentService.getPresentList(member);

        return Arrays.asList(result_image, presents);
    }




}
