package com.mhk.userinformation.controller;

import com.mhk.userinformation.service.UserInformationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserInformationController {

  private final UserInformationService userInformationService;

  public UserInformationController(UserInformationService userInformationService) {
    this.userInformationService = userInformationService;
  }


  @GetMapping("getUser/{id}")
  ResponseEntity getUser(@PathVariable String id) {
    return userInformationService.getUser(id);
  }

  @GetMapping("getAllUsers")
  ResponseEntity getAllUsers() {
    return userInformationService.getAllUsers();
  }


}
