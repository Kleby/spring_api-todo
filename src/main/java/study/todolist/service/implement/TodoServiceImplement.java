package study.todolist.service.implement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;
import study.todolist.model.Todo;
import study.todolist.repository.TodoRepository;
import study.todolist.service.TodoService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TodoServiceImplement implements TodoService {

    @Autowired
    private TodoRepository tr;

    @Override
    public List<Todo> getAllTodo(){
        return tr.findAll();
    }

    @Override
    public Todo getTodoById(Long id){
        return tr.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @Override
    public Todo addTodo(Todo todo){
        return tr.save(todo);
    }

    @Override
    public void deleteTodo(Long id){
        tr.deleteById(id);
    }

    @Override
    public Todo updateTodo(Long id){
        return tr.findById(id).map( todo -> {
            todo.setDone(true);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/YY HH:mm");
            todo.setDoneDate(LocalDateTime.now().format(dtf));
            tr.save(todo);
            return todo;
        }).orElse(null);
    }

}
