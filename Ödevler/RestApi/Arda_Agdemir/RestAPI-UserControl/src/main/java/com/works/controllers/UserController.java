package com.works.controllers;

import com.works.business.UserService;

import com.works.entities.User;
import com.works.entities.UserPassword;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity userRegister(@Valid @RequestBody User user){
        return userService.userRegister(user);
    }
    @PostMapping("/login")
    public ResponseEntity userLogin(@Valid @RequestBody User user){
        return userService.userLogin(user);
    }
    @GetMapping("/list")
    public ResponseEntity list(){
        return userService.list();
    }
    @PostMapping("/profileUpdate")
    public ResponseEntity profileUpdate(@RequestBody User user){
        return userService.profileUpdate(user);
    }
    @PostMapping("/passwordUpdate")
    public ResponseEntity passwordUpdate(@RequestBody UserPassword userPassword){
        return userService.passwordUpdate(userPassword);
    }
}
