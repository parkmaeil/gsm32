package com.example.demo.service;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService { // new BoardService();

    @Autowired
    private BoardRepository boardRepository;
    // 게시물 전체 가져오기
    public List<Board> findAll(){
        // 추가적인 로직 필요~~~
       return boardRepository.findAll(); // select * from ~~
    }

    public Board save(Board board){
        return boardRepository.save(board); // insert ~
    }

    public Optional<Board> findById(Long id){
       return boardRepository.findById(id); // where id=
    }
}
