package tj.project.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
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
}
