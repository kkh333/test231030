package org.example.wiseSaying.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class WiseSaying {
    private long id;
    private String content;
    private String author;
    private String writer;
}
