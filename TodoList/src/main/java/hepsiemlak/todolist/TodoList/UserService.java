package hepsiemlak.todolist.TodoList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerNewUser(User user) {
        // Kullanıcı adının zaten kullanımda olup olmadığını kontrol edin
        Optional<User> existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser.isPresent()) {
            // Eğer kullanıcı adı kullanımdaysa, bir hata fırlatın
            throw new RuntimeException("Username already in use");
        }

        // Kullanıcının şifresini hashleyin
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);

        // Kullanıcıyı veritabanına kaydedin
        return userRepository.save(user);
    }

    public User loginUser(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found"));
        if (passwordEncoder.matches(password, user.getPassword())) {
            return user;
        } else {
            throw new RuntimeException("Password mismatch");
        }
    }

    public void logoutUser(User user) {
        // Logout işlemi genellikle session veya token bazlı sistemlerde gerçekleşir
        // Bu basit örnekte spesifik bir işlem yapılmamaktadır
    }
}