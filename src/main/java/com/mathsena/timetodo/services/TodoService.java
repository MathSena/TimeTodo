package com.mathsena.timetodo.services;

import com.mathsena.timetodo.domain.Todo;
import com.mathsena.timetodo.repository.TodoRepository;
import com.mathsena.timetodo.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoService {

  @Autowired private TodoRepository repository;

  public Todo findTodoById(Integer id) {
    Optional<Todo> obj = repository.findById(id);
    return obj.orElseThrow(
        () ->
            new ObjectNotFoundException(
                "Objecto não encontrado!: " + id + ", tipo: " + Todo.class.getName()));
  }

  public List<Todo> findAllOpen() {
    return repository.findAllOpen();
  }

  public List<Todo> findAllClosed() {
    return repository.findAllClosed();
  }

  public List<Todo> findAllTodos() {
    return repository.findAll();
  }

  public Todo createTodo(Todo todo) {
    todo.setId(null);
    return repository.save(todo);
  }

  public void delete(Integer id) {
    repository.deleteById(id);
  }
}
