package com.example.demo.entity;

import lombok.*;

import java.util.Date;

// id	title	content	writer	indate	cnt
// : 필드, 멤버, 속성, 프로퍼티(*) : property , 상태정보
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
    private int id;
    private String title;
    private String content;
    private String writer;
    private Date indate;
    private int cnt;

}
