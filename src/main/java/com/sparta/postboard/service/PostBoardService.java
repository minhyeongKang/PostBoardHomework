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
        String pwd =  postBoard.getPassword();
        String checkPwd =  requestDto.getPassword();
        System.out.println("pwd => " + pwd);
        System.out.println("checkPwd => " + checkPwd);

        if (pwd.equals(checkPwd)) {
            postBoard.update(requestDto);
            System.out.println("비밀번호 일치로 수정 성공");
        } else {
            System.out.println("비밀번호 불일치로 수정 실패");
        }


        return id;
    }

    public Long deletePostBoard(Long id, PostBoardRequestDto requestDto) {
        PostBoard postBoard = findPostBoard(id);
        String pwd =  postBoard.getPassword();
        String checkPwd =  requestDto.getPassword();
        System.out.println("pwd => " + pwd);
        System.out.println("checkPwd => " + checkPwd);

        if (pwd.equals(checkPwd)) {
            postBoardRepository.delete(postBoard);
            System.out.println("비밀번호 일치로 삭제 성공");
        } else {
            System.out.println("비밀번호 불일치로 삭제 실패");
        }


        return id;
    }

    private PostBoard findPostBoard(Long id) {
        return postBoardRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시글은 존재하지 않습니다." )
        );
    }
}
