package com.works.restcontrollers;

import com.works.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

    final UserService userService;

    public UserRestController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/allUser")
    public ResponseEntity allUser() {
        return userService.allUser();
    }

    @GetMapping("/singleUser/{id}")
    public ResponseEntity singleUser(@PathVariable String id) {
        return userService.singleUser(id);
    }


}
