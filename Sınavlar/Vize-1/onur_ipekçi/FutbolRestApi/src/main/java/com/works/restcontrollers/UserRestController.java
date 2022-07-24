package com.works.restcontrollers;

import com.works.entities.JoinTeamsUser;
import com.works.entities.User;
import com.works.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserRestController {
final UserService uService;

    public UserRestController(UserService uService) {
        this.uService = uService;
    }


    @PostMapping("/footballerRegister")
    public ResponseEntity footballerRegister(@RequestBody User user) {
        return uService.footballerRegister(user);
    }

    @PostMapping("/teamInsert")
    public ResponseEntity teamInsert(@RequestBody JoinTeamsUser joinTeamsUser) {
        return uService.teamInsert(joinTeamsUser);
    }


}
