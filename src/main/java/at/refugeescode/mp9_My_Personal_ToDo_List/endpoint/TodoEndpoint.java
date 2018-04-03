package at.refugeescode.mp9_My_Personal_ToDo_List.endpoint;

import at.refugeescode.mp9_My_Personal_ToDo_List.logic.TodoCompleter;
import at.refugeescode.mp9_My_Personal_ToDo_List.persistence.model.Todo;
import at.refugeescode.mp9_My_Personal_ToDo_List.persistence.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todos")
@RequiredArgsConstructor
public class TodoEndpoint {

    private final TodoRepository todoRepository;
    private final TodoCompleter todoCompleter;

    @GetMapping
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    @PostMapping
    public Todo saveNew(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }

    @GetMapping("/{id}")
    public Todo findOne(@PathVariable String id) {
        return todoRepository.findById(id).orElse(null);
    }

    @PostMapping("{id}/done")
    public Todo saveDone(@PathVariable String id) {
        return todoCompleter.switchIsDone(id);
    }

}
