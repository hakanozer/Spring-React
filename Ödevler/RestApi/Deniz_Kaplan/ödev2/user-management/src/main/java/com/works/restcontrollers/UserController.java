package com.works.restcontrollers;

import com.works.Request.UpdatePassword;
import com.works.entities.User;
import com.works.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody User user)
    {
        return userService.save(user);
    }

    @GetMapping
    public ResponseEntity getAll(){
        return userService.getALL();
    }

    @PostMapping("/login")
    public ResponseEntity login( @RequestBody User user ) {
        return userService.login(user);
    }

    @PutMapping("/update")
    public ResponseEntity update(@Valid @RequestBody User user){
        return  userService.update(user);
    }

    @PutMapping("/updatePassword/{id}")
    public ResponseEntity updatePassword(@PathVariable int id, @RequestBody UpdatePassword updatePassword){
        return userService.updatePassword(id,updatePassword);
    }

}
