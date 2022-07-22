package com.example.userprojem.controllers;


import com.example.userprojem.entities.User;
import com.example.userprojem.entities.UserPassChange;
import com.example.userprojem.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRestController {

    final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("/userLogin")
    public ResponseEntity userLogin(@RequestBody User user){
        return  userService.userLogin(user);
    }

    @PostMapping("/passwordChange")
    public ResponseEntity passwordChange(@RequestBody UserPassChange userPassChange){
        return userService.passwordChange(userPassChange);
    }

    @PostMapping("/updateSettings")
    public ResponseEntity updateSettings(@RequestBody User user){
        return userService.updateSettings(user);
    }

}
