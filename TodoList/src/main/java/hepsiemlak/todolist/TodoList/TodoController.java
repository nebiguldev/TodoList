package hepsiemlak.todolist.TodoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {
    @Autowired
    private TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoItem> addTodoItem(@RequestBody TodoItem todoItem) {
        return ResponseEntity.ok(todoService.addTodoItem(todoItem));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoItem> updateTodoItem(@PathVariable Long id, @RequestBody TodoItem todoItem) {
        return ResponseEntity.ok(todoService.updateTodoItem(id, todoItem));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoItem(@PathVariable Long id) {
        todoService.deleteTodoItem(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<TodoItem>> getAllTodoItems() {
        return ResponseEntity.ok(todoService.getAllTodoItems());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TodoItem> getTodoItemById(@PathVariable Long id) {
        return ResponseEntity.ok(todoService.getTodoItemById(id));
    }
}
