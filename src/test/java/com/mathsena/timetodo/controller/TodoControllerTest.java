package com.mathsena.timetodo.controller;

import com.mathsena.timetodo.domain.Todo;
import com.mathsena.timetodo.services.TodoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Objects;

import static org.mockito.Mockito.*;

class TodoControllerTest {

  @Mock TodoService service;

  @InjectMocks TodoController todoController;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("Find Todo by its ID")
  void testFindById() {
    when(service.findTodoById(anyInt()))
        .thenReturn(
            new Todo(
                0,
                "title",
                "description",
                LocalDateTime.of(2023, Month.SEPTEMBER, 27, 23, 31, 12),
                true));

    ResponseEntity<Todo> result = todoController.findById(0);
    Assertions.assertEquals(
        new Todo(
            0,
            "title",
            "description",
            LocalDateTime.of(2023, Month.SEPTEMBER, 27, 23, 31, 12),
            true),
        result.getBody());
  }

  @Test
  @DisplayName("List all open Todos")
  void testListOpen() {
    when(service.findAllOpen())
        .thenReturn(
            List.of(
                new Todo(
                    0,
                    "title",
                    "description",
                    LocalDateTime.of(2023, Month.SEPTEMBER, 27, 23, 31, 12),
                    true)));

    ResponseEntity<List<Todo>> result = todoController.listOpen();
    Assertions.assertEquals(1, Objects.requireNonNull(result.getBody()).size());
    Assertions.assertEquals(
        new Todo(
            0,
            "title",
            "description",
            LocalDateTime.of(2023, Month.SEPTEMBER, 27, 23, 31, 12),
            true),
        result.getBody().get(0));
  }

  @Test
  @DisplayName("List all closed Todos")
  void testListClosed() {
    when(service.findAllClosed())
        .thenReturn(
            List.of(
                new Todo(
                    0,
                    "title",
                    "description",
                    LocalDateTime.of(2023, Month.SEPTEMBER, 27, 23, 31, 12),
                    true)));

    ResponseEntity<List<Todo>> result = todoController.listClosed();
    Assertions.assertEquals(1, Objects.requireNonNull(result.getBody()).size());
    Assertions.assertEquals(
        new Todo(
            0,
            "title",
            "description",
            LocalDateTime.of(2023, Month.SEPTEMBER, 27, 23, 31, 12),
            true),
        result.getBody().get(0));
  }

  @Test
  @DisplayName("List all Todos")
  void testListAllTodos() {
    when(service.findAllTodos())
        .thenReturn(
            List.of(
                new Todo(
                    0,
                    "title",
                    "description",
                    LocalDateTime.of(2023, Month.SEPTEMBER, 27, 23, 31, 12),
                    true)));

    ResponseEntity<List<Todo>> result = todoController.listAllTodos();
    Assertions.assertEquals(1, Objects.requireNonNull(result.getBody()).size());
    Assertions.assertEquals(
        new Todo(
            0,
            "title",
            "description",
            LocalDateTime.of(2023, Month.SEPTEMBER, 27, 23, 31, 12),
            true),
        result.getBody().get(0));
  }

  @Test
  @DisplayName("Create a Todo")
  void testCreateTodo() {
    when(service.createTodo(any()))
        .thenReturn(
            new Todo(
                0,
                "title",
                "description",
                LocalDateTime.of(2023, Month.SEPTEMBER, 27, 23, 31, 12),
                true));

    ResponseEntity<Todo> result =
        todoController.createTodo(
            new Todo(
                0,
                "title",
                "description",
                LocalDateTime.of(2023, Month.SEPTEMBER, 27, 23, 31, 12),
                true));
    Assertions.assertEquals(
        new Todo(
            0,
            "title",
            "description",
            LocalDateTime.of(2023, Month.SEPTEMBER, 27, 23, 31, 12),
            true),
        result.getBody());
  }

  @Test
  @DisplayName("Delete a Todo")
  void testDeleteTodo() {
    ResponseEntity<Void> result = todoController.deleteTodo(0);
    Assertions.assertNull(result.getBody());
  }

  @Test
  @DisplayName("Update a Todo")
  void testUpdateTodos() {
    when(service.update(anyInt(), any()))
        .thenReturn(
            new Todo(
                0,
                "title",
                "description",
                LocalDateTime.of(2023, Month.SEPTEMBER, 27, 23, 31, 12),
                true));

    ResponseEntity<Todo> result =
        todoController.updateTodos(
            0,
            new Todo(
                0,
                "title",
                "description",
                LocalDateTime.of(2023, Month.SEPTEMBER, 27, 23, 31, 12),
                true));
    Assertions.assertEquals(
        new Todo(
            0,
            "title",
            "description",
            LocalDateTime.of(2023, Month.SEPTEMBER, 27, 23, 31, 12),
            true),
        result.getBody());
  }
}
