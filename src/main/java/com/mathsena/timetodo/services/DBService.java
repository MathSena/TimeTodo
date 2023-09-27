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
        Todo todo2 =
                new Todo(
                        null,
                        "Academia",
                        "Estudo de spring boot",
                        LocalDateTime.parse("25/03/2022 19:40", formatter),
                        true);

        Todo todo3 =
                new Todo(
                        null,
                        "Leitura",
                        "Estudo de spring boot",
                        LocalDateTime.parse("25/03/2022 19:40", formatter),
                        false);

        Todo todo4 =
                new Todo(
                        null,
                        "Estudo FIAP",
                        "Estudo de spring boot",
                        LocalDateTime.parse("25/03/2022 19:40", formatter),
                        true);

        todoRepository.saveAll(List.of(todo1, todo2, todo3, todo4));

    }
}
