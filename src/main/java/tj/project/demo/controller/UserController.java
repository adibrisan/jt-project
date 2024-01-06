package tj.project.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tj.project.demo.entity.User;
import tj.project.demo.service.UserService;

import java.util.Set;

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
}
