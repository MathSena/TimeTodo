package com.mathsena.timetodo.services;

import com.mathsena.timetodo.domain.Todo;
import com.mathsena.timetodo.repository.TodoRepository;
import com.mathsena.timetodo.services.exceptions.ObjectNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
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
    log.info("Deleting Todo by id: {}", id);
    repository.deleteById(id);
  }

  public Todo update(Integer id, Todo obj) {
    log.info("Updating Todo by id: {}", id);
    Todo newObj = findTodoById(id);
    newObj.setTitle(obj.getTitle());
    newObj.setTimeToFinish(obj.getTimeToFinish());
    newObj.setDescription(obj.getDescription());
    newObj.setFinished(obj.isFinished());
    return repository.save(newObj);
  }
}
