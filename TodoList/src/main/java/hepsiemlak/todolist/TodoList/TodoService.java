package hepsiemlak.todolist.TodoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public TodoItem addTodoItem(TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }

    public TodoItem updateTodoItem(Long id, TodoItem todoItem) {
        TodoItem existingItem = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TodoItem not found"));
        existingItem.setTitle(todoItem.getTitle());
        existingItem.setCompleted(todoItem.isCompleted());
        return todoRepository.save(existingItem);
    }

    public void deleteTodoItem(Long id) {
        todoRepository.deleteById(id);
    }

    public List<TodoItem> getAllTodoItems() {
        return todoRepository.findAll();
    }

    public TodoItem getTodoItemById(Long id) {
        return todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TodoItem not found"));
    }
}
