package at.refugeescode.mp9_My_Personal_ToDo_List.persistence.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
@NoArgsConstructor
public class Todo {

    @Id
    private String id;
    private String task;
    private boolean done;

    @Override
    public String toString() {
        return "Todo{" +
                "id='" + id + '\'' +
                ", task='" + task + '\'' +
                ", done=" + done +
                '}';
    }

}

