package com.mathsena.timetodo.repository;

import com.mathsena.timetodo.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    @Query("SELECT obj FROM Todo obj WHERE obj.isFinished = false ORDER BY obj.timeToFinish")
    List<Todo> findAllOpen();

    @Query("SELECT obj FROM Todo obj WHERE obj.isFinished = true ORDER BY obj.timeToFinish")
    List<Todo> findAllClosed();
}
