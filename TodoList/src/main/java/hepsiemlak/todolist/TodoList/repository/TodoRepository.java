package hepsiemlak.todolist.TodoList.repository;

import hepsiemlak.todolist.TodoList.entity.TodoItem;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CouchbaseRepository<TodoItem, Long> {
    List<TodoItem> findByUserId(Long userId);
}