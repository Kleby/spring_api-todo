package study.todolist.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;
import study.todolist.model.Todo;

import study.todolist.service.TodoService;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/todos")
@CrossOrigin("http://localhost:4200")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public ResponseEntity<List<Todo>> getAllTodo(){
        return ResponseEntity.ok(todoService.getAllTodo());
    }

    @PostMapping("/save")
    public ResponseEntity<Todo> addTodo(@RequestBody Todo todo){
        todoService.addTodo(todo);
        return ResponseEntity.ok(todo);
    }

    @GetMapping("{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable Long id){
        return ResponseEntity.ok(todoService.getTodoById(id));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id){
        todoService.deleteTodo(id);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/{id}/done")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id){
        todoService.updateTodo(id);
        return ResponseEntity.ok().build();
    }
}
