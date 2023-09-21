package com.mathsena.timetodo.services;

import com.mathsena.timetodo.domain.Todo;
import com.mathsena.timetodo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class DBService {

    @Autowired
    private TodoRepository todoRepository;

    public void instanceDataBase(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        Todo todo1 =
                new Todo(
                        null,
                        "Estudar Spring",
                        "Estudo de spring boot",
                        LocalDateTime.parse("25/03/2022 19:40", formatter),
                        false);

        todoRepository.saveAll(List.of(todo1));

    }
}
