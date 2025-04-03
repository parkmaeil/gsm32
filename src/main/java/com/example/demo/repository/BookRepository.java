package com.example.demo.repository;

import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long > {
   // finaAll()
   // JPQL :
   // 1. fetch join(Book, Review)
   @Query("select distinct b from Book b LEFT JOIN FETCH b.reviews")
   public List<Book> findWithBookReviews();
   // 2. @EntityGraph
   @EntityGraph(attributePaths = {"reviews","reviews.customer"})
   public List<Book> findAll(); // 자동생성 ?

   // Book, Review, Customer
   @Query("""
           SELECT DISTINCT b FROM Book b
           LEFT JOIN FETCH b.reviews r
           LEFT JOIN FETCH r.customer
           """)
   List<Book> findAllWithReviewsAndCustomer();
}
/*
select b.id, b.title, r.id, r.content
from book b
left join review r
on b.id=r.book_id;
 */