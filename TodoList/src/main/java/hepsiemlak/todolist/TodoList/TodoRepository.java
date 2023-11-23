package hepsiemlak.todolist.TodoList;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CouchbaseRepository<TodoItem, Long> {
    List<TodoItem> findByUserId(Long userId);
}