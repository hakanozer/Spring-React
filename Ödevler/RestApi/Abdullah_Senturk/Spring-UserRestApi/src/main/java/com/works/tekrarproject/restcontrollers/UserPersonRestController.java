package com.works.tekrarproject.restcontrollers;

import com.works.tekrarproject.entities.UserPassword;
import com.works.tekrarproject.entities.UserPerson;
import com.works.tekrarproject.services.UserPersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userperson")
public class UserPersonRestController {

    final UserPersonService upService;

    public UserPersonRestController(UserPersonService upService) {
        this.upService = upService;
    }

    @PostMapping("/register")
    public ResponseEntity register( @RequestBody UserPerson userPerson ) {
        return upService.register( userPerson );
    }

    @PostMapping("/settings")
    public ResponseEntity settings( @RequestBody UserPerson userPerson ) {
        return upService.settings( userPerson );
    }

    @PostMapping("/passwordChange")
    public ResponseEntity passwordChange(@RequestBody UserPassword userPassword ) {
        return upService.passwordChange( userPassword );
    }

}
