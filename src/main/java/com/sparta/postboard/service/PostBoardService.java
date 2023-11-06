package com.sparta.postboard.service;

import com.sparta.postboard.dto.PostBoardRequestDto;
import com.sparta.postboard.dto.PostBoardResponseDto;
import com.sparta.postboard.entity.PostBoard;
import com.sparta.postboard.repository.PostBoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostBoardService {

    private final PostBoardRepository postBoardRepository;

    public PostBoardService(PostBoardRepository postBoardRepository) {
        this.postBoardRepository = postBoardRepository;
    }

    public PostBoardResponseDto createPostBoard(PostBoardRequestDto requestDto) {
        PostBoard postBoard = new PostBoard(requestDto);
        PostBoard savePostBoard = postBoardRepository.save(postBoard);
        PostBoardResponseDto postBoardResponseDto = new PostBoardResponseDto(postBoard);

        return postBoardResponseDto;
    }

    public List<PostBoardResponseDto> getPostBoard() {
        return postBoardRepository.findAllByOrderByModifiedAtDesc().stream().map(PostBoardResponseDto::new).toList();
    }

    @Transactional
    public Long updatePostBoard(Long id, PostBoardRequestDto requestDto) {
        PostBoard postBoard = findPostBoard(id);

        postBoard.update(requestDto);

        return id;
    }

    public Long deletePostBoard(Long id) {
        PostBoard postBoard = findPostBoard(id);

        postBoardRepository.delete(postBoard);

        return id;
    }

    private PostBoard findPostBoard(Long id) {
        return postBoardRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시글은 존재하지 않습니다." )
        );
    }
}
