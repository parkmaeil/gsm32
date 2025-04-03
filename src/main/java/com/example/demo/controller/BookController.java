package com.example.demo.controller;

import com.example.demo.payload.BookDTO;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bapi")
public class BookController {
    private final BookService bookService;

    // GET : /bapi/books
    @GetMapping("/books")
    public List<BookDTO> getAllLists(){
        List<BookDTO> lists=bookService.getAllLists();
        // MessageConverter가 @Entity 적용
        // open-in-view: false
        // Book연결된 Review정보 가져올려고 시도? EntityManager Open
        // 순환참조 문제 발생? -> 해결? Entity -> DTO 해결
        return lists; // List<Book> : [ {   },{   } ]
    }
}
