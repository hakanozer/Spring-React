package com.works.restcontrollers;

import com.works.entities.User;
import com.works.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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

    @GetMapping("/list")
    public ResponseEntity list() {
        return uService.list();
    }


    @DeleteMapping("/delete")
    public ResponseEntity delete( @RequestParam String id ) {
        return uService.delete(id);
    }


    @GetMapping("/single")
    public ResponseEntity single( @RequestParam String id ) {
        return uService.single(id);
    }

    @PutMapping("/update")
    public ResponseEntity update( @RequestBody User user ) {
        return uService.update(user);
    }


}
