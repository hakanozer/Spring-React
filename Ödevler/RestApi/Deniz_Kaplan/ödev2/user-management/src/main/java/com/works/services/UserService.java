package com.works.services;

import com.works.Request.UpdatePassword;
import com.works.entities.User;
import com.works.repositories.UserRepository;
import com.works.utils.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ResponseEntity save(User user) {
        Map<String, Object> hm = new LinkedHashMap<>();
        user.setEmail(user.getEmail()+"@gmail.com");
        List<User> users=userRepository.findAll();
        Optional<User> ispresent=users.stream().filter(e->e.getEmail().equals(user.getEmail())).findFirst();
        if (ispresent.isPresent()){
            hm.put("status", false);
            hm.put("message","mail daha önceden kayıtlı");
        }else{
            String newPass = Util.md5(user.getPassword());
            user.setPassword(newPass);
            userRepository.save(user);
            hm.put("status", true);
            hm.put("result", user);
        }

        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity getALL() {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        hm.put("result", userRepository.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity login(User loguser) {
        Map<String, Object> hm = new LinkedHashMap<>();
        String newPass = Util.md5( loguser.getPassword());
        Optional<User> user=userRepository.findByEmailContainsIgnoreCaseAndPasswordContainsIgnoreCase(loguser.getEmail(),newPass);
        if (user.isPresent()){
            hm.put("status", true);
            hm.put("message", "Login Success");
        }
        else {
            hm.put("status", false);
            hm.put("message", "Login fail");
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity update(User upuser) {
        Map<String, Object> hm = new LinkedHashMap<>();
        Optional<User> user=userRepository.findById(upuser.getUid());
        if(user.isPresent()){
            user.get().setName(upuser.getName());
            user.get().setSurname(upuser.getSurname());
            user.get().setEmail(upuser.getEmail());
            userRepository.save(user.get());
            hm.put("status", true);
            hm.put("message", "Update Success");
        }else{
            hm.put("status", false);
            hm.put("message", "Update Fail");
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity updatePassword(int id, UpdatePassword updatePassword) {
        Map<String, Object> hm = new LinkedHashMap<>();
        String oldPass=Util.md5(updatePassword.getOldPassword());
        String newPass = Util.md5(updatePassword.getNewPassword());
        Optional<User> user=userRepository.findById(id);
        if (user.isPresent()){
            if(user.get().getPassword().equals(oldPass) && !oldPass.equals(newPass)){
                hm.put("status", true);
                hm.put("message", "Update Pass Success");
                user.get().setPassword(newPass);
                userRepository.save(user.get());
            }
            else {
                hm.put("status", false);
                hm.put("message", "Update Password Fail");
            }
        }


        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
