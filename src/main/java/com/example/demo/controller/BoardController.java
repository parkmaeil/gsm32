package com.example.demo.controller;

import com.example.demo.entity.Board;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 클라이언트의 요청(URL)을 받는 작업
@RestController // View(jsp, HTML)
@RequestMapping("/api")
public class BoardController {
    // 게시판 보기(/boardList)
    // http://localhost:8080/api/board
    @GetMapping("/board")
    public List<Board> getLists(){
        Board board1=new Board(1, "자바", "자바","홍길동", new Date(), 1);
        Board board2=new Board(2, "자바", "자바","홍길동", new Date(), 1);
        Board board3=new Board(3, "자바", "자바","홍길동", new Date(), 1);
        List<Board> list=new ArrayList<>();
        list.add(board1);
        list.add(board2);
        list.add(board3);
        return list; // list(Object)--MessageConverter->JSON : [{   },{   },{   }]
    }
    // GET : http://localhost:8080/api/board/2
    // GET : http://localhost:8080/api/board?id=2
    @GetMapping("/board/{id}")
    public Board getById(@PathVariable int id){
        Board board2=new Board(2, "자바", "자바","홍길동", new Date(), 1);
        return board2; // board2(Object)---> JSON : {     }
    }
    // POST : http://localhost:8080/api/board
    // Data : { title:"자바", content:"자바", writer:"홍길동" }
    @PostMapping("/board")
    public Board register(@RequestBody Board board){ // JSON->Board
        // 저장?
        return board;
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