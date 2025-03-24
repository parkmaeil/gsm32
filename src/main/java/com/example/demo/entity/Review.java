package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Review { //리뷰 -누가작성(Customer), 무슨책(Book)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int cost; // 1~5점
    private String content; // 내용
    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate(){
        this.createdAt=LocalDateTime.now();
    }
    // 책과 관계(1:1, N:1,1:N, M:N)를 설정
    @ManyToOne
    // FK 만들기
    @JoinColumn(name = "book_id", nullable = false)
    private Book book; // book_id

    // 고객 관계 설정
    @ManyToOne
    // FK 만들기
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer; // customer_id
}
