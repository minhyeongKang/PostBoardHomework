package com.sparta.postboard.controller;

import com.sparta.postboard.dto.PostBoardRequestDto;
import com.sparta.postboard.dto.PostBoardResponseDto;
import com.sparta.postboard.service.PostBoardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostBoardController {

    private final PostBoardService postBoardService;

    public PostBoardController(PostBoardService postBoardService) {
        this.postBoardService = postBoardService;
    }

    @PostMapping("/posts")
    public PostBoardResponseDto createPostBoard(@RequestBody PostBoardRequestDto requestDto) {
        return postBoardService.createPostBoard(requestDto);
    }

    @GetMapping("/posts")
    public List<PostBoardResponseDto> getPostBoard() {
        return postBoardService.getPostBoard();
    }

    @PutMapping("/posts/{id}")
    public Long updatePostBoard(@PathVariable Long id, @RequestBody PostBoardRequestDto requestDto) {
        return postBoardService.updatePostBoard(id, requestDto);
    }

    @DeleteMapping("/posts/{id}")
    public Long deletePostBoard(@PathVariable Long id) {
        return postBoardService.deletePostBoard(id);
    }
}
