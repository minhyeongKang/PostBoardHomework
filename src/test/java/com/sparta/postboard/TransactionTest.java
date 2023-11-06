package com.sparta.postboard;

import com.sparta.postboard.entity.PostBoard;
import com.sparta.postboard.repository.PostBoardRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class TransactionTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    PostBoardRepository postBoardRepository;

    @Test
    @Transactional
    @Rollback(value = false)
    @DisplayName("게시글 생성 성공")
    void test1() {
        PostBoard postBoard = new PostBoard();
        postBoard.setUsername("강민형");
        postBoard.setContents("테스트입니다22.");

        em.persist(postBoard);
    }

    @Test
    @Disabled
    @DisplayName("메모 생성 실패")
    void test2() {
        PostBoard postBoard = new PostBoard();
        postBoard.setUsername("Robbie");
        postBoard.setContents("@Transactional 테스트 중!");

        em.persist(postBoard);
    }

    @Test
    @Disabled
    @DisplayName("트랜잭션 전파 테스트")
    void test3() {
        System.out.println("테스트 test3 메서드 종료");
    }
}
