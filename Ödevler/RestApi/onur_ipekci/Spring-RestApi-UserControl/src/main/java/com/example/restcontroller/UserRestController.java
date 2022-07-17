package com.example.restcontroller;

import com.example.entities.UserPerson;
import com.example.entities.UserPersonPassword;
import com.example.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserRestController {
    final UserService uService;

    public UserRestController(UserService uService) {
        this.uService = uService;
    }


    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserPerson user) {
        return uService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity login( @RequestBody UserPerson userPerson ) {return uService.login(userPerson);}

    @PostMapping ("/settings")
    public ResponseEntity settings(@RequestBody UserPerson userPerson ) {return uService.settings(userPerson);}

    @PostMapping("/passwordChange")
    public ResponseEntity passwordChange(@RequestBody UserPersonPassword userPersonPassword ) {return uService.passwordChange(userPersonPassword);}
}
