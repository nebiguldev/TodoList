package hepsiemlak.todolist.TodoList.controller;

import hepsiemlak.todolist.TodoList.service.UserService;
import hepsiemlak.todolist.TodoList.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody User user) {
        User registeredUser = userService.registerNewUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestParam String username, @RequestParam String password) {
        User loggedInUser = userService.loginUser(username, password);
        return ResponseEntity.ok(loggedInUser);
    }

    @PostMapping("/logout")
    public ResponseEntity<String> logoutUser(@RequestBody User user) {
        userService.logoutUser(user);
        return ResponseEntity.ok("Logged out successfully");
    }
}