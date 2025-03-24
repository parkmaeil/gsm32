package com.example.demo.service;

import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import jakarta.persistence.EntityNotFoundException;
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
    public Optional<Board> findByTitle(String title){
        return boardRepository.searchTitle(title); // where title=
    }

    public Board save(Long id, Board reqBoard){
        return boardRepository.findById(id).map(board->{
            board.setTitle(reqBoard.getTitle());
            board.setContent(reqBoard.getContent());
            //return boardRepository.save(board); // 명시적으로 update
            return board; // 수정(JPA 더티체킹)
        }).orElseThrow(() -> new EntityNotFoundException("Board not found with id: " + id));
    }

    public void deleteById(Long id) {
        Board board=boardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Board not found with id: " + id));
        boardRepository.delete(board);
        //boardRepository.deleteById(id);
    }
    //조회수 증가 메서드
    public void addCount(Long id) {
        Board board=boardRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Board not found with id: " + id));
        board.setCount(board.getCount()+1);
        boardRepository.save(board);
        //boardRepository.deleteById(id);
    }
}
