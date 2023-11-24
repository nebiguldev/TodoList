package hepsiemlak.todolist.TodoList.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;

import java.util.UUID;


@Document
public class TodoItem {
    @Id
    private UUID id;
    private String title;
    private boolean completed;
    private UUID userId; // Kullanıcıya ait TO-DO

    public TodoItem(UUID id, String title, boolean completed, UUID userId) {
        this.id = id;
        this.title = title;
        this.completed = completed;
        this.userId = userId;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }
}