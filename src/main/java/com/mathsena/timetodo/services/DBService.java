package com.mathsena.timetodo.services;

import com.mathsena.timetodo.domain.Todo;
import com.mathsena.timetodo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class DBService {

    @Autowired
    private TodoRepository todoRepository;

    public void instanceDataBase() throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Todo todo1 =
                new Todo(
                        null,
                        "Estudar Spring",
                        "Estudo de spring boot",
                        dateFormat.parse("25/03/2022"),
                        false);
        Todo todo2 =
                new Todo(
                        null,
                        "Academia",
                        "Estudo de spring boot",
                        dateFormat.parse("25/03/2022"),
                        true);

        Todo todo3 =
                new Todo(
                        null,
                        "Leitura",
                        "Estudo de spring boot",
                        dateFormat.parse("25/03/2022"),
                        false);

        Todo todo4 =
                new Todo(
                        null,
                        "Estudo FIAP",
                        "Estudo de spring boot",
                        dateFormat.parse("25/03/2022"),
                        true);

        todoRepository.saveAll(List.of(todo1, todo2, todo3, todo4));

    }
}
