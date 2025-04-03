package com.example.demo.payload;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
public class BookReviewDTO {
    private Long id;
    private String title;
    private int price;
    private String author;
    private int page;

    private int cost; // 1~5점
    private String content; // 내용
    private LocalDateTime createdAt;
}
