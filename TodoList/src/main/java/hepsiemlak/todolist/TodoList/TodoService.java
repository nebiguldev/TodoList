package hepsiemlak.todolist.TodoList;

import com.couchbase.client.core.error.CouchbaseException;
import com.couchbase.client.java.kv.IncrementOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.CouchbaseOperations;
import org.springframework.data.couchbase.core.CouchbaseTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.UUID;

@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private UserRepository userRepository;

    private final CouchbaseTemplate couchbaseTemplate;
    private final String COUNTER_ID = "todoCounter";

    public TodoService(TodoRepository todoRepository,UserRepository userRepository, CouchbaseTemplate couchbaseTemplate) {
        this.todoRepository = todoRepository;
        this.userRepository=userRepository;
        this.couchbaseTemplate = couchbaseTemplate;
    }







    public TodoItem createTodoItem(TodoItem item, UUID userId) {
        try {
//            Long newId = couchbaseTemplate.getCouchbaseClientFactory()
//                    .getDefaultCollection()
//                    .binary()
//                    .increment(COUNTER_ID, IncrementOptions.incrementOptions().delta(1).initial(0))
//                    .content();

            // Yeni ID'yi ayarla
            item.setId(UUID.randomUUID());

            // Kullanıcının todolist koleksiyonuna ekle
            User user = userRepository.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));
            user.getTodoItems().add(item);

            // TodoItem'i veritabanına ve kullanıcının güncellenmiş todolist koleksiyonuna ekleyin
            todoRepository.save(item);
            userRepository.save(user);

            return item;
        } catch (CouchbaseException e) {
            // Hata durumunu işle
            e.printStackTrace();
            // Diğer işlemleri ekleyebilirsiniz.
            return null; // veya başka bir işlem
        }
    }
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
