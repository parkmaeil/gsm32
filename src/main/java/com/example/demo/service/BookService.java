package com.example.demo.service;

import com.example.demo.entity.*;
import com.example.demo.payload.BookDTO;
import com.example.demo.payload.CustomerDTO;
import com.example.demo.payload.ReviewDTO;
import com.example.demo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {

   private final BookRepository bookRepository; // DI(생성자 주입)

   //책 전체 목록 가져오기...(연습)
   @Transactional(readOnly = true)
   public List<BookDTO> getAllLists(){
       // 순환참조 문제를 해결 ? -> DTO
       List<Book> books=bookRepository.findAll(); // 1번 SQL
       //List<Book> books=bookRepository.findWithBookReviews();
       //List<Book> books=bookRepository.findAllWithReviewsAndCustomer();
       System.out.print(books.size()); //5
       return books.stream().map(book->{
           //                       N+1 문제 발생?
          List<ReviewDTO> reviews=book.getReviews().stream().map((review)->{
              Customer customer = review.getCustomer();
              CustomerDTO customerDto = new CustomerDTO(customer.getUsername(), customer.getName());
              return new ReviewDTO(review.getId(), review.getCost(),review.getContent(), review.getCreatedAt(), customerDto);
          }).toList();
          return new BookDTO(book.getId(),book.getTitle(),book.getPrice(),book.getAuthor(),book.getPage(), reviews);
       }).toList(); // EntityManager가 실행
   }
}
/*
   select DISTINCT b from Book b LEFT JOIN FETCH b.reviews

   select
      b.id, b.title, b.price, ....,
      r.id, r.content, r.book_id, r.customer_id
   from book b
   LEFT JOIN review r ON b.id=r.book_id

"JPA는 DB 결과가 여러 줄이 나와도, 같은 Book ID면 하나의 Book 객체로만 조립합니다.
그래서 row는 3개지만 Book 객체는 1개예요.
그런데 이걸 더 안전하게 하기 위해 우리는 DISTINCT를 써서 JPA에게 'Book은 중복 없이 가져와!'라고 명확하게 지시하는 겁니다."

    book_id	title	review_id	content
    1	자바의 정석	101	좋아요
    1	자바의 정석	102	최고예요
    1	자바의 정석	103	또 사고 싶어요

    Book(id=1, title="자바의 정석", reviews=[
        Review(id=101, content="좋아요"),
        Review(id=102, content="최고예요"),
        Review(id=103, content="또 사고 싶어요")
    ])

 */