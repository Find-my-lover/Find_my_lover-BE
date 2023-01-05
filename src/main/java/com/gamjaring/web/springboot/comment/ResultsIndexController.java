package com.gamjaring.web.springboot.comment;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class ResultsIndexController {

    private final ResultsService resultsService;

    /* 글 상세보기 */
    @GetMapping("/results/read/{id}")
    public String read(@PathVariable Long id, @LoginUser UserSessionDto user, Model model) {
        ResultsResponseDto dto = resultsService.findById(id);
        List<CommentResponseDto> comments = dto.getComments();

        /* 코맨트 관련 */
        if (comments != null && !comments.isEmpty()) {
            model.addAttribute("comments", comments);
        }

        /* 사용자 관련 */
        if (user != null) {
            model.addAttribute("user", user.getNickname());
        }
        resultsService.updateView(id); // views ++
        model.addAttribute("posts", dto);
        return "results/results-read";
    }
}
