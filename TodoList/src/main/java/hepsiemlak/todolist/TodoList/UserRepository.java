package hepsiemlak.todolist.TodoList;


import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CouchbaseRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
