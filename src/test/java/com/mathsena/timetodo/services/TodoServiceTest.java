package com.mathsena.timetodo.services;

import com.mathsena.timetodo.domain.Todo;
import com.mathsena.timetodo.repository.TodoRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;

class TodoServiceTest {
  @Mock TodoRepository repository;

  @InjectMocks TodoService todoService;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  @DisplayName("Find Todo by its ID")
  void testFindTodoById() {

    Todo mockTodo =
        new Todo(
            0,
            "title",
            "description",
            LocalDateTime.of(2023, Month.SEPTEMBER, 27, 23, 21, 6),
            true);

    // Mocking the behavior of repository
    when(repository.findById(0)).thenReturn(Optional.of(mockTodo));

    Todo result = todoService.findTodoById(0);

    Assertions.assertEquals(mockTodo, result);
  }

  @Test
  @DisplayName("Find all open Todos")
  void testFindAllOpen() {
    when(repository.findAllOpen())
        .thenReturn(
            List.of(
                new Todo(
                    0,
                    "title",
                    "description",
                    LocalDateTime.of(2023, Month.SEPTEMBER, 27, 23, 21, 6),
                    true)));

    List<Todo> result = todoService.findAllOpen();
    Assertions.assertEquals(
        List.of(
            new Todo(
                0,
                "title",
                "description",
                LocalDateTime.of(2023, Month.SEPTEMBER, 27, 23, 21, 6),
                true)),
        result);
  }

  @Test
  @DisplayName("Find all closed Todos")
  void testFindAllClosed() {
    when(repository.findAllClosed())
        .thenReturn(
            List.of(
                new Todo(
                    0,
                    "title",
                    "description",
                    LocalDateTime.of(2023, Month.SEPTEMBER, 27, 23, 21, 6),
                    true)));

    List<Todo> result = todoService.findAllClosed();
    Assertions.assertEquals(
        List.of(
            new Todo(
                0,
                "title",
                "description",
                LocalDateTime.of(2023, Month.SEPTEMBER, 27, 23, 21, 6),
                true)),
        result);
  }

  @Test
  @DisplayName("Find all Todos")
  void testFindAllTodos() {

    Todo mockTodo =
        new Todo(
            0,
            "title",
            "description",
            LocalDateTime.of(2023, Month.SEPTEMBER, 27, 23, 21, 6),
            true);

    // Mocking the behavior of repository
    when(repository.findAll()).thenReturn(List.of(mockTodo));

    List<Todo> result = todoService.findAllTodos();

    Assertions.assertEquals(List.of(mockTodo), result);
  }

  @Test
  @DisplayName("Create a new Todo")
  void testCreateTodo() {
    Todo result =
        todoService.createTodo(
            new Todo(
                0,
                "title",
                "description",
                LocalDateTime.of(2023, Month.SEPTEMBER, 27, 23, 21, 6),
                true));
    Assertions.assertEquals(
        new Todo(
            0,
            "title",
            "description",
            LocalDateTime.of(2023, Month.SEPTEMBER, 27, 23, 21, 6),
            true),
        result);
  }

  @Test
  @DisplayName("Delete a Todo by its ID")
  void testDelete() {
    todoService.delete(0);

    // If TodoService uses a repository or data access object
    verify(repository, times(1)).deleteById(0);
  }

  @Test
  @DisplayName("Update a Todo")
  void testUpdate() {

    Todo existingTodo =
        new Todo(
            0,
            "old title",
            "old description",
            LocalDateTime.of(2023, Month.SEPTEMBER, 27, 20, 0, 0),
            false);

    Todo updatedTodo =
        new Todo(
            0,
            "title",
            "description",
            LocalDateTime.of(2023, Month.SEPTEMBER, 27, 23, 21, 6),
            true);

    // Mocking the behavior of repository to find the existingTodo
    when(repository.findById(0)).thenReturn(Optional.of(existingTodo));

    // Mocking the behavior of repository to save the updatedTodo
    when(repository.save(any(Todo.class))).thenReturn(updatedTodo);

    Todo result =
        todoService.update(
            0,
            new Todo(
                0,
                "title",
                "description",
                LocalDateTime.of(2023, Month.SEPTEMBER, 27, 23, 21, 6),
                true));

    Assertions.assertEquals(updatedTodo, result);
  }
}
