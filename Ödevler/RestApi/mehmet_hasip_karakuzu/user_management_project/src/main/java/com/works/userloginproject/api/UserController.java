package com.works.userloginproject.api;

import com.works.userloginproject.entities.User;
import com.works.userloginproject.services.UserService;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("register")
  ResponseEntity registerUser(@Valid @RequestBody User user) {
    return userService.registerUser(user);
  }

  @PostMapping("login")
  ResponseEntity loginUser(@RequestBody User user) {
    return userService.login(user);
  }

  @PutMapping("update/{id}")
  ResponseEntity updateUserInformation(@PathVariable Long id, @RequestBody User user) {
    return ResponseEntity.ok(userService.updateUserInformation(id, user));
  }

  @PutMapping("updatePassword/{id}")
  ResponseEntity<User> updateUserPassword(@PathVariable Long id, @RequestBody User user) {
    return ResponseEntity.ok(userService.updateUserPassword(id, user));
  }

}
