package com.works.userlogin.restcontrollers;


import com.works.userlogin.entities.User;
import com.works.userlogin.entities.UserPassword;
import com.works.userlogin.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserControler {
    final UserService uService;

    public UserControler(UserService uService) {
        this.uService = uService;
    }


    @PostMapping("/login")
    public ResponseEntity login(@RequestBody User user ) {
        return uService.login(user);
    }



    @PostMapping("/save")
    ResponseEntity save (@Valid @RequestBody User user){
        return uService.registerUser(user);
    }

    @PutMapping("/update")
    public ResponseEntity update( @RequestBody User user ) {
        return uService.update(user);
    }



    @PostMapping("/passwordChange")
    public ResponseEntity passwordChange(@RequestBody UserPassword userPassword) {
        return uService.passwordChange(userPassword);
    }





}
