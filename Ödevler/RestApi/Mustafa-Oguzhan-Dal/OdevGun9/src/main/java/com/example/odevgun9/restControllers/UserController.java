package com.example.odevgun9.restControllers;

import com.example.odevgun9.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public ResponseEntity news() {
        return userService.getAllUsers();
    }

    @GetMapping("/getid/{id}")
    public ResponseEntity singleUser(@PathVariable String id) {
        return userService.singleUser(id);

    }
}
