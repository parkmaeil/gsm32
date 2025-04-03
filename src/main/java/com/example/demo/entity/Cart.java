package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //PK(인공키)

    private int quantity; //수량
    private LocalDateTime cartDate; // 구매일자

    @PrePersist
    public void onCreate(){
        this.cartDate=LocalDateTime.now();
    }
    // Cart(N) - Customer(1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;// FK=customer_id

    // Cart(N) - Book(1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;// FK=book_id


}
