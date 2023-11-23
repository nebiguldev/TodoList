package hepsiemlak.todolist.TodoList;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TodoItem {
    @Id
    private Long id;
    private String title;
    private boolean completed;
    private Long userId; // Kullanıcıya ait TO-DO öğesi

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}