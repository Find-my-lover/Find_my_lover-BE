package com.gamjaring.web.springboot.comment;

import com.gamjaring.web.springboot.config.auth.LoginUser;
import com.gamjaring.web.springboot.dto.UserSessionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class CommentApiController {

    private final CommentService commentService;

    /* CREATE */
    @PostMapping("/results/{id}/comments")
    public ResponseEntity commentSave(@PathVariable Long id, @RequestBody CommentRequestDto dto,
                                      @LoginUser UserSessionDto userSessionDto) {
        return ResponseEntity.ok(commentService.commentSave(userSessionDto.getEmail(), id, dto));
    }
}