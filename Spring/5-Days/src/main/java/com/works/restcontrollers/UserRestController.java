package com.works.restcontrollers;

import com.works.entities.User;
import com.works.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserRestController {

    final UserService uService;
    public UserRestController(UserService uService) {
        this.uService = uService;
    }


    @PostMapping("/save")
    public ResponseEntity save(@RequestBody User user) {
        return uService.save(user);
    }


    @PostMapping("/login")
    public ResponseEntity login( @RequestBody User user ) {
        return uService.login(user);
    }

    @GetMapping("/search")
    public ResponseEntity search( @RequestParam String q ) {
        return uService.search(q);
    }

}
