package com.works.restcontrollers;

import com.works.entities.UserPerson;
import com.works.services.UserPersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserRestController {

   final UserPersonService uService;
    public UserRestController(UserPersonService uService) {
        this.uService = uService;
    }

    @PostMapping("/register")
    public ResponseEntity register( @RequestBody UserPerson userPerson) {
        return uService.register( userPerson );
    }


}
