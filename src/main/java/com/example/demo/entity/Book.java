package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
public class Book { //책(1) - 리뷰(N) - BookDTO
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int price;
    private String author;
    private int page;
    // 리뷰와 관계설정
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL,
               fetch = FetchType.LAZY)
    private List<Review> reviews; // 1번 책에 대한 리뷰

    // Book(1) - Cart(N)
    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL,
                fetch = FetchType.LAZY)
    private List<Cart> carts;
}
