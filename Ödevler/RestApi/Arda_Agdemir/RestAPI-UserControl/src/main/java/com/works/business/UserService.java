package com.works.business;

import com.works.utilities.ERest;
import com.works.entities.User;

import com.works.entities.UserPassword;
import com.works.repositories.UserRepository;
import com.works.utilities.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity userRegister(User user) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        boolean singStatus = userRepository.existsByEmailEqualsAllIgnoreCase(user.getEmail());
        if (singStatus){
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Kullanıcı Kayıtlı");
        }
        else {
            user.setPassword(Util.md5(user.getPassword()));
            hm.put(ERest.status, true);
            userRepository.save(user);
            hm.put(ERest.result, user);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity userLogin (User user){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        String newPass = Util.md5(user.getPassword());
        Optional<User> optionalUser = userRepository.findByEmailEqualsAndPasswordEquals(user.getEmail(), newPass);
        if (optionalUser.isPresent()){
            hm.put(ERest.status, true);
            hm.put(ERest.message, "Giriş Yapıldı");

            User u = optionalUser.get();
            u.setPassword("secur");
            hm.put(ERest.result, optionalUser.get());
        }
        else {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Kullanıcı adı veya şifre yanlış");
        }

        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity profileUpdate(User user){
        Map<String, Object> hm = new LinkedHashMap<>();
        Optional<User> optionalUser = userRepository.findById(user.getUserId());
        if (optionalUser.isPresent()){

            //dbUser -> DB-Data
            User dbUser = optionalUser.get();

            dbUser.setName(user.getName());
            dbUser.setSurname(user.getSurname());
            dbUser.setEmail(user.getEmail());

            userRepository.saveAndFlush(dbUser);
            hm.put("status", true);
            hm.put("result", dbUser);
        }
        else {
            hm.put("status", false);
            hm.put("result", user);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity passwordUpdate(UserPassword userPassword){
        Map<String, Object> hm = new LinkedHashMap<>();
        Optional<User> optionalUser = userRepository.findById(userPassword.getUserId());
        if (optionalUser.isPresent()){
            User dbUser = optionalUser.get();
            if (dbUser.getPassword().equals(Util.md5(userPassword.getOldPassword()))){
                String jsonNewPassword = Util.md5(userPassword.getNewPassword());
                dbUser.setPassword(jsonNewPassword);
                userRepository.saveAndFlush(dbUser);
                hm.put("status", true);
                dbUser.setPassword("secur");
                hm.put("result", dbUser);
            }
            else {
                hm.put("status", false);
                hm.put("result", userPassword);
            }
        }
        else {
            hm.put("status", false);
            hm.put("result", userPassword);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list(){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        List<User> ls = userRepository.findAll();
        hm.put(ERest.status, true);
        hm.put(ERest.result, ls);
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}