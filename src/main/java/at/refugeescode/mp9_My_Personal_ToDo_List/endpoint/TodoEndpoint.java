package at.refugeescode.mp9_My_Personal_ToDo_List.endpoint;

import at.refugeescode.mp9_My_Personal_ToDo_List.persistence.model.Todo;
import at.refugeescode.mp9_My_Personal_ToDo_List.persistence.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TodoEndpoint {

    private final TodoRepository todoRepository;

    @GetMapping("/todos")
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @PostMapping("/todos")
    public Todo saveNew(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @GetMapping("/todos/{id}")
    public Todo findOne(@PathVariable String id) {
        return todoRepository.findById(id).orElse(null);
    }

    @PostMapping("/todos/{id}/done")
    public Todo saveDone(@PathVariable String id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            todo.setDone(true);
            return todoRepository.save(todo);
        }
        return null;
    }

}
