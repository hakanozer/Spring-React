package com.works.services;

import com.works.entities.User;
import com.works.entities.UserPassword;
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

    final UserRepository uRepo;
    public UserService(UserRepository uRepo) {
        this.uRepo = uRepo;
    }

    public ResponseEntity save(User user) {
        Map<String, Object> hm = new LinkedHashMap<>();
        String newPass = Util.md5(user.getPassword());
        user.setPassword(newPass);
        uRepo.save(user);
        hm.put("status", true);
        hm.put("result", user);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity login( User user ) {
        Map<String, Object> hm = new LinkedHashMap<>();
        String newPass = Util.md5( user.getPassword() );
        Optional<User> oUser = uRepo.findByEmailEqualsAndPasswordEquals(user.getEmail(), newPass );
        if (oUser.isPresent() ) {
            hm.put("status", true);
            hm.put("message", "Login Success");
            User u = oUser.get();
            u.setPassword("secur");
            hm.put("result", u );
        }else {
            hm.put("status", false);
            hm.put("message", "Email or Password Fail");
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity search( String q ) {
        Map<String, Object> hm = new LinkedHashMap<>();
        List<User> ls = uRepo.findByNameContainsIgnoreCaseOrSurnameContainsIgnoreCase(q,q);
        hm.put("total", uRepo.countAllBy());
        hm.put("searchTotal", ls.size() );
        hm.put("status", true);
        hm.put("users", ls);
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity profileUpdate( User user ) {
        Map<String, Object> hm = new LinkedHashMap<>();
        Optional<User> oUser = uRepo.findById(user.getUid());
        if (oUser.isPresent() ) {
            User dbUser = oUser.get();
            dbUser.setName(user.getName());
            dbUser.setAge( user.getAge() );
            dbUser.setEmail(user.getEmail());
            dbUser.setSurname(user.getSurname());
            uRepo.saveAndFlush(dbUser);
            dbUser.setPassword("secur");
            hm.put("status", true);
            hm.put("result", dbUser);
        }else {
            hm.put("status", false);
            hm.put("result", user);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity passwordChange(UserPassword userPassword) {
        Map<String, Object> hm = new LinkedHashMap<>();
        Optional<User> oUser = uRepo.findById( userPassword.getUid() );
        if ( oUser.isPresent() ) {
            User dbUser = oUser.get();
            String dbOldPassword = dbUser.getPassword();
            String jsonOldPassword = Util.md5( userPassword.getOldPassword() );
            if ( dbOldPassword.equals( jsonOldPassword ) ) {
                String jsonNewPassword = Util.md5( userPassword.getNewPassword() );
                dbUser.setPassword( jsonNewPassword );
                uRepo.saveAndFlush( dbUser );
                hm.put("status", true);
                dbUser.setPassword("secur");
                hm.put("result", dbUser);
            }else {
                hm.put("status", false);
                hm.put("result", userPassword);
            }
        }else {
            hm.put("status", false);
            hm.put("result", userPassword);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
