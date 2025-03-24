package com.example.demo.repository;

import com.example.demo.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    // 1. JpaRepository에서 제공해주는 메서드 사용
    // CRUD 기본 메서드(?)를 만들지않는다.<--JpaRepository
    // save(Board  board) - insert SQL
    // findAll() - select SQL
    // findById() - select ~ where ~ SQL
    // save() - update SQL
    // deleteById() - delete ~ where ~ SQL
    // 2. Query Method(규칙)
    public Optional<Board> findByTitle(String title);
    // JPQL : select b from Board b where b.title=?1 and b.aaa=:aaa
    // 3. JPQL(Entity) > SQL(Table)
    @Query("select b from Board b where b.title=:aaa")
    public Optional<Board> getTitle(@Param("aaa") String title);
    // 4. Table 기준 SQL
    @Query(value = "select * from board where title=?1", nativeQuery = true)
    public Optional<Board> searchTitle(String title);
    //5. Querydsl

}
// EntityManagerFactory

