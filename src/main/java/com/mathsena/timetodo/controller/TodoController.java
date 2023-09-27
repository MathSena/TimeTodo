package com.mathsena.timetodo.controller;

import com.mathsena.timetodo.domain.Todo;
import com.mathsena.timetodo.services.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/todos")
public class TodoController {

  @Autowired private TodoService service;

  @GetMapping(value = "/{id}")
  public ResponseEntity<Todo> findById(@PathVariable Integer id) {
    Todo todo = service.findTodoById(id);
    return ResponseEntity.ok().body(todo);
  }

  @GetMapping(value = "/open")
  public ResponseEntity<List<Todo>> listOpen() {
    List<Todo> list = service.findAllOpen();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping(value = "/closed")
  public ResponseEntity<List<Todo>> listClosed() {
    List<Todo> list = service.findAllClosed();
    return ResponseEntity.ok().body(list);
  }

  @GetMapping
  public ResponseEntity<List<Todo>> listAllTodos() {
    List<Todo> list = service.findAllTodos();
    return ResponseEntity.ok().body(list);
  }

  @PostMapping
  public ResponseEntity<Todo> createTodo(@RequestBody Todo todo) {

    todo = service.createTodo(todo);
    URI uri =
        ServletUriComponentsBuilder.fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(todo.getId())
            .toUri();
    return ResponseEntity.created(uri).body(todo);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<Void> deleteTodo(@PathVariable Integer id) {
    service.delete(id);
    return ResponseEntity.noContent().build();
  }
}
