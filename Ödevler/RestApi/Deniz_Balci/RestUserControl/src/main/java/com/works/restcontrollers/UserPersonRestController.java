package com.works.restcontrollers;

import com.works.entities.UserPerson;
import com.works.entities.UserPersonPasswordChange;
import com.works.services.UserPersonServices;
import com.works.utils.ERest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/userperson")
public class UserPersonRestController {

    final UserPersonServices userPersonServices;

    public UserPersonRestController(UserPersonServices userPersonServices) {
        this.userPersonServices = userPersonServices;
    }

    @PostMapping("/register")
    public ResponseEntity register (@RequestBody UserPerson userPerson){
        return userPersonServices.register(userPerson);
    }
    @PostMapping("/login")
    public ResponseEntity login (@RequestBody UserPerson userPerson){
        return userPersonServices.login(userPerson);
    }
    @PostMapping("/update")
    public  ResponseEntity update (@RequestBody UserPerson userPerson){
        return userPersonServices.update(userPerson);
    }
    @PostMapping("/changePassword")
    public ResponseEntity changePassword (@RequestBody UserPersonPasswordChange userPersonPasswordChange){
        return userPersonServices.changePassword(userPersonPasswordChange);
    }

}
