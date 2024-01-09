package tj.project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tj.project.demo.entity.User;
import tj.project.demo.repository.UserRepository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User addUser(User newUser){
        return userRepository.save(newUser);
    }

    public Set<User> getAllUsers(){
        List<User> userList = userRepository.findAll();
        return new HashSet<>(userList);
    }

    public ResponseEntity<User> getUserById(Long userId){
        User existingUser = userRepository.findUserByUserId(userId);
        if(existingUser != null){
            return ResponseEntity.ok(existingUser);
        }
        return ResponseEntity.notFound().build();
    }

    public ResponseEntity<User> getUser(String user, String password){
        User existingUser = userRepository.findByUserAndPassword(user,password);
        if(existingUser != null){
            return ResponseEntity.ok(existingUser);
        }
        return ResponseEntity.notFound().build();
    }
}
