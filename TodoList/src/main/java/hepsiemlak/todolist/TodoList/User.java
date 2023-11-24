package hepsiemlak.todolist.TodoList;



import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Document
public class User {
    @Id
    @Field
    private UUID id;
    @Field
    private String username;
    @Field
    private String password;

    // Kullanıcının todolist'lerini temsil eden koleksiyon
    @Field
    private List<TodoItem> todoItems = new ArrayList<>();

    public List<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void setTodoItems(List<TodoItem> todoItems) {
        this.todoItems = todoItems;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}