package com.sparta.week02_hw.models;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@NoArgsConstructor
@Getter
public class Comment extends Timestamped {

    @Id
    @GeneratedValue
    @Column(name = "COMMENT_ID")
    private Long id;
    private String author;
    private String content;
    private Board board;


    @Builder
    public Comment(String author, String content, Board board) {
        this.author = author;
        this.content = content;
        this.board = board;

    }

    public void modify(String content) {
        this.content = content;
    }

}