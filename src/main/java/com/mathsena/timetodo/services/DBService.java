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

  @Autowired private TodoRepository todoRepository;

  public void instanceDataBase() throws ParseException {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    Todo todo1 =
        new Todo(
            null,
            "Acordar antes das 7am",
            "Definir o alarme para as 6:45am",
            dateFormat.parse("25/03/2022"),
                true);
    Todo todo2 =
        new Todo(
            null,
            "Fazer sua rotina matinal",
            "Exercícios de alongamento e meditação",
            dateFormat.parse("25/03/2022"),
                false);
    Todo todo3 =
        new Todo(
            null,
            "Ler 10 paginas por dia",
            "Leitura de um livro escolhido",
            dateFormat.parse("25/03/2022"),
                false);
    Todo todo4 =
        new Todo(
            null,
            "Execitar 1h por dia",
            "Correr ou ir à academia",
            dateFormat.parse("25/03/2022"),
                false);
    Todo todo5 =
        new Todo(
            null,
            "Tomar 2L de água",
            "Beber um copo de água a cada hora",
            dateFormat.parse("25/03/2022"),
                false);
    Todo todo6 =
        new Todo(
            null,
            "Seguir uma dieta saudável",
            "Evitar junk food e comer mais vegetais",
            dateFormat.parse("25/03/2022"),
                false);
    Todo todo7 =
        new Todo(
            null,
            "Dormir antes das 10pm",
            "Evitar telas uma hora antes de dormir",
            dateFormat.parse("25/03/2022"),
            false);

    todoRepository.saveAll(List.of(todo1, todo2, todo3, todo4, todo5, todo6, todo7));
  }
}
