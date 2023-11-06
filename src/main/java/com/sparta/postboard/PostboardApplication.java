package com.sparta.postboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PostboardApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostboardApplication.class, args);
    }

}
