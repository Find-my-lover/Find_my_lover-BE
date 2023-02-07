package com.gamjaring.web.springboot.controller;

import com.gamjaring.web.springboot.config.auth.LoginUser;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Api(tags={"results"})
@RestController(value = "/main")
@RequestMapping("/ringmybell")
@RequiredArgsConstructor
public class ResultsIndexController {


//    private final ResultsService resultsService;
//
//    /* 글 상세보기 */
//    @GetMapping("/results/read/{id}")
//    public String read(@PathVariable Long id, @LoginUser UserSessionDto user, Model model) {
//        ResultsResponseDto dto = resultsService.findById(id);
//        List<CommentResponseDto> comments = dto.getComments();
//
//        /* 코맨트 관련 */
//        if (comments != null && !comments.isEmpty()) {
//            model.addAttribute("comments", comments);
//        }
//
//        /* 사용자 관련 */
//        if (user != null) {
//            model.addAttribute("user", user.getEmail());
//        }
//        resultsService.updateView(id); // views ++
//        model.addAttribute("posts", dto);
//        return "results/results-read";
//    }
}
