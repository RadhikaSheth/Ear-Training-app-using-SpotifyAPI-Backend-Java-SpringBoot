package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping()
public class Controller {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/user", produces = "application/json")
    @CrossOrigin(origins = "*")
    public List<User> getUserProfile(@RequestParam String userId, @RequestParam String accessToken) {
        return userService.getProfile(userId,accessToken);
    }

    @PostMapping(path = "/entry", consumes = "application/json", produces = "application/json")
    @CrossOrigin(origins = "*")
    public User add(@RequestBody User user, @RequestParam String accessToken) {
        userService.appendEntry(user,accessToken);
        return user;
    }
}
