package com.works.springhomework.RestControllers;

import com.works.springhomework.Services.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestController {
    final UserServices uServices;

    public UserRestController(UserServices uServices) {
        this.uServices = uServices;
    }
    @GetMapping("/user")
    public ResponseEntity user() {
        return uServices.AllUser();

    }
    @GetMapping("/singleUser/{id}")
    public ResponseEntity singleUser(@PathVariable String id){
        return uServices.singleUser(id);

    }
    }