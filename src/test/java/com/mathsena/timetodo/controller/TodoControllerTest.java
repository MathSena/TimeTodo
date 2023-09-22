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

import static org.mockito.Mockito.*;
class TodoControllerTest {
    @Mock
    TodoService service;
    @InjectMocks
    TodoController todoController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Testing findById method")
    void testFindById(){
    when(service.findTodoById(anyInt()))
        .thenReturn(
            new Todo(
                1L,
                "title",
                "description",
                LocalDateTime.of(2023, Month.SEPTEMBER, 22, 19, 20, 49),
                true));

    ResponseEntity<Todo> result = todoController.findById(0);
        Assertions.assertNotEquals(null, result);
    }
}
