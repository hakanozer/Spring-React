package com.works.restcontrollers;

import com.works.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    final UserService uService;
    public UserRestController(UserService uService) {
        this.uService = uService;
    }

    @GetMapping("/singleUser/{id}")
    public ResponseEntity singleUser(@PathVariable String id) {
        return uService.singleUser(id);
    }

    @GetMapping("/allUser")
    public ResponseEntity allUser() {
        return uService.allUser();
    }

}
