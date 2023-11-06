package com.sparta.postboard.dto;

import com.sparta.postboard.entity.PostBoard;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostBoardResponseDto {

    private Long id;
    private String username;
    private String contents;
    private String password;
    private LocalDateTime createdAt;
    private LocalDateTime modifideAt;

    public PostBoardResponseDto(PostBoard postBoard) {
        this.id = postBoard.getId();
        this.username = postBoard.getUsername();
        this.contents = postBoard.getContents();
        this.password = postBoard.getPassword();
        this.createdAt = postBoard.getCreatedAt();
        this.modifideAt = postBoard.getModifiedAt();
    }
}
