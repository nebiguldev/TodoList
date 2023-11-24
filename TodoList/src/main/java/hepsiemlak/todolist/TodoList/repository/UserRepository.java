package hepsiemlak.todolist.TodoList.repository;


import hepsiemlak.todolist.TodoList.entity.User;
import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends CouchbaseRepository<User,Long> {
    Optional<User> findByUsername(String username);

    Optional<User> findById(UUID userId);
}
