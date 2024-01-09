package tj.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tj.project.demo.entity.User;
import tj.project.demo.service.UserService;

import java.util.Set;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/user-cars")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping
    public User addUser(@RequestBody User newUser){
        return userService.addUser(newUser);
    }

    @GetMapping
    public Set<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/login")
    public ResponseEntity<User> getUser(@RequestParam("user") String user,@RequestParam("password") String password) {
        return userService.getUser(user,password);
    }
}
