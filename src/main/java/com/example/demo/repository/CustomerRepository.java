package com.example.demo.repository;

import com.example.demo.entity.Book;
import com.example.demo.entity.Customer;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  // fetch join
   @Query("""
           SELECT DISTINCT c FROM Customer c
           LEFT JOIN FETCH c.carts ct
           LEFT JOIN FETCH ct.book
           """)
   public List<Customer> findAllWithCartsAndBooks();

   // EntityGraph
   @EntityGraph(attributePaths = {"carts","carts.book"})
   public List<Customer> findAll();
}
