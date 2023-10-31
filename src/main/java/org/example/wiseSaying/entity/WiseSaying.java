package org.example.wiseSaying.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@AllArgsConstructor

public class WiseSaying {
    private long id;
    private String content;
    private String author;
    private String writer;

    public WiseSaying(Map<String, Object> row) {
        this.id = 1; // 테스트 값
        this.author = (String) row.get("author");
        this.content = (String) row.get("content");
        this.writer = "tester"; // 테스트 값
    }
}
