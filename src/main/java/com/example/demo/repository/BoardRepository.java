package com.example.demo.repository;

import com.example.demo.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    // CRUD 기본 메서드(?)를 만들지않는다.<--JpaRepository
    // save(Board  board) - insert SQL
    // findAll() - select SQL
    // findById() - select ~ where ~ SQL
    // save() - update SQL
    // deleteById() - delete ~ where ~ SQL

}
// EntityManagerFactory

