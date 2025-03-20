package com.example.demo.controller;

import com.example.demo.entity.Board;
import com.example.demo.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

// 클라이언트의 요청(URL)을 받는 작업
@RestController // View(jsp, HTML)
@RequestMapping("/api")
public class BoardController {

    @Autowired
    private BoardService boardService;
    // 게시판 보기(/boardList)
    // http://localhost:8080/api/board
    @GetMapping("/board")
    public List<Board> getLists(){
        return boardService.findAll(); // list(Object)--MessageConverter->JSON : [{   },{   },{   }]
    }
    // GET : http://localhost:8080/api/board/2
    // GET : http://localhost:8080/api/board?id=2
    @GetMapping("/board/{id}")
    public Board getById(@PathVariable Long id){
        Optional<Board> optional=boardService.findById(id);
        Board board=null;
        if(optional.isPresent()){
            board=optional.get();
            return board;
        }
        return null; // board2(Object)---> JSON : {     }
    }
    // POST : http://localhost:8080/api/board
    // Data : { title:"자바", content:"자바", writer:"홍길동" }
    @PostMapping("/board")
    public Board register(@RequestBody Board board){ // JSON->Board
        return boardService.save(board);
    }
    // PUT : http://localhost:8080/api/board/{id}
    // Data : { title:"자바", content:"자바" }
    @PutMapping("/board/{id}")
    public Board modify(@PathVariable int id, @RequestBody Board board){
        // 수정?
        return board;
    }

    // DELETE : http://localhost:8080/api/board/{id}
    @DeleteMapping("/board/{id}")
    public int remove(@PathVariable int id){
        // 삭제?
        return 1;
    }
}
// Restfull Service(API)
// MySQL DBMS -> Database : gsm32