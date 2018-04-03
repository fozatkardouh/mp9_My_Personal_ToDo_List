package at.refugeescode.mp9_My_Personal_ToDo_List.logic;

import at.refugeescode.mp9_My_Personal_ToDo_List.persistence.model.Todo;
import at.refugeescode.mp9_My_Personal_ToDo_List.persistence.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoCompleter {

    private final TodoRepository todoRepository;

    public Todo switchIsDone(@PathVariable String id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isPresent()) {
            Todo todo = optionalTodo.get();
            todo.setDone(true);
            return todoRepository.save(todo);
        }
        return null;
    }

}
