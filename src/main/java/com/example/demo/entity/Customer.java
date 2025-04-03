package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String username; // 사용자 id
    private String password; // 비번->암호화

    private String name; // 이름
    private int age;

    // 리뷰의 관계
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL
               ,fetch = FetchType.LAZY)
    private List<Review> reviews;

    // Customer(1) - Cart(N)
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL
                ,fetch = FetchType.LAZY)
    private List<Cart> carts; //table의 컬럼이 아니다
}
