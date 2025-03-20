package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

// Board(Object)---mapping-->DB Table
// ORM
// Spring JPA API
@Entity
@Getter
@Setter
public class Board { // 번호(PK), 제목, 내용, 작성자....
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //null
    @Column(length = 100, nullable = false)
    private String title; // varchar(255)

    private String content;
    private String writer;
    private LocalDateTime createdAt; // null

    @PrePersist
    protected void onCreate(){
        this.createdAt=LocalDateTime.now();
    }

    private int count; // 0
    //
}
