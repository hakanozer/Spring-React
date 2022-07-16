package com.example.userprojem.services;

import com.example.userprojem.entities.User;
import com.example.userprojem.entities.UserPassChange;
import com.example.userprojem.repositories.UserRepository;
import com.example.userprojem.utils.ERest;
import com.example.userprojem.utils.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public ResponseEntity register(User user) {
        boolean isAccountAdded = userRepository.existsByEmailEqualsIgnoreCase(user.getEmail());
        Map<ERest, Object> hm = new LinkedHashMap<>();
        if (isAccountAdded) {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "kayıtlı kullanıcı ile tekrar kayıt olamassınız..");
        } else {
            user.setPassword(Util.md5(user.getPassword()));
            hm.put(ERest.status, true);
            userRepository.save(user);
            hm.put(ERest.result, user);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity userLogin(User user) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        String newPass = Util.md5(user.getPassword());
        Optional<User> optionalUser = userRepository.findByEmailEqualsAndPasswordEqualsAllIgnoreCase(user.getEmail(), newPass);
        if (optionalUser.isPresent()) {
            hm.put(ERest.status, true);
            hm.put(ERest.message, "login success");
            User user1 = optionalUser.get();
            user1.setPassword("secure password by inan");
            hm.put(ERest.result, optionalUser.get());
        } else {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "login fail!!");

        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity passwordChange(UserPassChange userPassChange) {
        Map<ERest, Object> hm = new LinkedHashMap<>();

        Optional<User> optionalUser = userRepository.findById(userPassChange.getUid());

        if (optionalUser.isPresent()) {
            User dbUser = optionalUser.get();
            if (dbUser.getPassword().equals(Util.md5(userPassChange.getPassword()))) {
                String jsonWithNewPassword = Util.md5(userPassChange.getNewPassword());
                dbUser.setPassword(jsonWithNewPassword);
                userRepository.saveAndFlush(dbUser);
                hm.put(ERest.status, true);
                dbUser.setPassword("secure password by inan");
                hm.put(ERest.result, dbUser);
            } else {
                hm.put(ERest.status, false);
                hm.put(ERest.result, userPassChange);
            }

        } else {
            hm.put(ERest.status, false);
            hm.put(ERest.result, userPassChange);
        }

        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity updateSettings(User user) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Optional<User> optionalUser = userRepository.findById(user.getUid());
        if (optionalUser.isPresent()) {
            User dbUser = optionalUser.get();
            dbUser.setName(user.getName());
            dbUser.setSurname(user.getSurname());
            dbUser.setEmail(user.getEmail());
            userRepository.saveAndFlush(dbUser);
            hm.put(ERest.status, true);
            dbUser.setPassword("secure password by inan");
            hm.put(ERest.result, dbUser);
        } else {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "we dont find user");
            hm.put(ERest.result, user);
        }


        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
