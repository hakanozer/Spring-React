package com.work.restcontroller;

import com.work.entities.NewPerson;
import com.work.entities.UserPerson;
import com.work.services.UserServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserRestControllers {

    final UserServices uServices;

    public UserRestControllers(UserServices uServices) {
        this.uServices = uServices;
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UserPerson userPerson){

        return uServices.register(userPerson);
    }
    @PostMapping("/userLogin")
    public ResponseEntity userLogin(@RequestBody UserPerson userPerson){
        return uServices.userLogin(userPerson);
    }

    @PostMapping("/updateSettings")
    public ResponseEntity updateSettings(@RequestBody UserPerson userPerson){
        return uServices.updateSettings(userPerson);
    }

    @PostMapping("/passwordChange")
    public ResponseEntity passwordChange(@RequestBody NewPerson newPerson){
        return uServices.passwordChange(newPerson);
    }
}
