package study.todolist.service;

import org.springframework.stereotype.Service;
import study.todolist.model.Todo;

import java.util.List;

@Service
public interface TodoService {

    public List<Todo> getAllTodo();

    Todo getTodoById(Long id);

    Todo addTodo(Todo todo);

    void deleteTodo(Long id);

    Todo updateTodo(Long id);
}
