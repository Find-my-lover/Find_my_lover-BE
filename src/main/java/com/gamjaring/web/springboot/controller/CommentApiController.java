package com.gamjaring.web.springboot.controller;

import com.gamjaring.web.springboot.config.auth.LoginUser;
import com.gamjaring.web.springboot.dto.UserSessionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ringmybell")
public class CommentApiController {

    private final CommentServiceImpl commentServiceImpl;

    /* CREATE */
//    @PostMapping("/results/{id}/comments")
//    public ResponseEntity commentSave(@PathVariable Long id, @RequestBody CommentRequestDto dto,
//                                      @LoginUser UserSessionDto userSessionDto) {
//        return ResponseEntity.ok(commentService.commentSave(userSessionDto.getEmail(), id, dto));
//    }
    @PostMapping("/friends/comment")
    public ResponseEntity commentSave(@RequestParam String email,
                                      @RequestBody CommentRequestDto dto,
                                      @LoginUser UserSessionDto userSessionDto) {
        return ResponseEntity.ok(commentServiceImpl.commentSave(userSessionDto.getEmail(), dto));
    }
}