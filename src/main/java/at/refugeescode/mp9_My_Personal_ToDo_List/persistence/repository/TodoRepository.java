package at.refugeescode.mp9_My_Personal_ToDo_List.persistence.repository;

import at.refugeescode.mp9_My_Personal_ToDo_List.persistence.model.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TodoRepository extends MongoRepository<Todo, String> {
}
