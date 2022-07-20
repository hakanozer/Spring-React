package com.example.odevgun9.restControllers;

import com.example.odevgun9.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class NewsRestController {
    final UserService userService;

    public NewsRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getAll")
    public ResponseEntity news() {
        return userService.getAllUsers2();
    }

    @GetMapping("/getid/{id}")
    public ResponseEntity userLogin(@PathVariable  int id) {
        return userService.getId(id);

    }
}
