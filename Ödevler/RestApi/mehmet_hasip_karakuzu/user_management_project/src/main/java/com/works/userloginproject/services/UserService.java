package com.works.userloginproject.services;

import com.works.userloginproject.entities.User;
import com.works.userloginproject.entities.UserUpdatePasswordDto;
import com.works.userloginproject.repositories.UserRepository;
import com.works.userloginproject.utils.Util;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public ResponseEntity registerUser(User user) {
    boolean presentEmail = userRepository.existsByEmailEqualsIgnoreCase(user.getEmail());
    Map<String, Object> hm = new LinkedHashMap<>();

    if (presentEmail) {
      hm.put("status", false);
      hm.put("message", "email is already in use");
    } else {
      user.setPassword(Util.md5(user.getPassword()));
      userRepository.save(user);
      hm.put("Status", true);
      hm.put("result", user);
    }

    return new ResponseEntity(hm, HttpStatus.OK);

  }

  public ResponseEntity login(User user) {
    Map<String, Object> hm = new LinkedHashMap<>();
    Optional<User> userInDb = userRepository.findByEmailEqualsAndPasswordEquals(
        user.getEmail(), Util.md5(user.getPassword()));

    if (userInDb.isPresent()) {
      hm.put("status", true);
      hm.put("message", "logged in successfully");
    } else {
      hm.put("status", false);
      hm.put("message", "incorrect email or password or you do not register yet");
    }

    return new ResponseEntity(hm, HttpStatus.OK);
  }

  public User updateUserInformation(Long id, User user) {
    User userInDb = userRepository.getReferenceById(id);
    if (userInDb != null) {
      userInDb.setName(user.getName());
      userInDb.setSurname(user.getSurname());
      userInDb.setEmail(user.getEmail());
    } else {
      throw new IllegalArgumentException("User does not exist");
    }
    return userRepository.saveAndFlush(userInDb);
  }

  public User updateUserPassword(Long id, User user) {
    User userInDb = userRepository.getReferenceById(id);
    if (userInDb.getPassword().equals(Util.md5(user.getOldPassword()))) {
      userInDb.setPassword(Util.md5(user.getPassword()));
    } else {
      throw new IllegalArgumentException(
          "Password could not matched!!!. Please be sure you entered your old password correctly.");
    }
    return userRepository.saveAndFlush(userInDb);
  }

}
