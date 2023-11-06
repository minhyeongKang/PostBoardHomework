package com.sparta.postboard.repository;

import com.sparta.postboard.entity.PostBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostBoardRepository extends JpaRepository<PostBoard, Long> {
        List<PostBoard> findAllByOrderByModifiedAtDesc();
}
