package com.example.tekrarcalisma.restcontrollers;

import com.example.tekrarcalisma.entities.NewUserPerson;
import com.example.tekrarcalisma.entities.UserPerson;
import com.example.tekrarcalisma.services.UserPersonService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserServiceRestControllers {


        final UserPersonService uService;
        public UserServiceRestControllers(UserPersonService uService){
            this.uService = uService;
        }

        @PostMapping("/register")
        public ResponseEntity register(@RequestBody UserPerson userPerson){
            return uService.register(userPerson);
        }

        @PostMapping("/Login")
        public ResponseEntity Login(@RequestBody UserPerson userPerson){
            return uService.Login(userPerson);
        }

        @PostMapping("/Settings")
        public ResponseEntity Settings(@RequestBody UserPerson userPerson){
            return uService.Settings(userPerson);
         }

         @PostMapping("/passwordChange")
        public ResponseEntity passwordChange(@RequestBody NewUserPerson newUserPerson){
            return uService.passwordChange(newUserPerson);
         }



}

