package com.works.userlogin.services;


import com.works.userlogin.entities.User;
import com.works.userlogin.entities.UserPassword;
import com.works.userlogin.repositories.UserRepository;
import com.works.userlogin.utils.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    final UserRepository uRepo;

    public UserService(UserRepository uRepo) {
        this.uRepo = uRepo;
    }

    public ResponseEntity registerUser (User user){
        Map<String, Object> hm = new LinkedHashMap<>();

        boolean emailControl = uRepo.existsByEmailEquals(user.getEmail());
        if (emailControl) {
            hm.put("status",false);
            hm.put("message","Bu email daha önce kullanılmıştır.");
        }
        else {
            user.setPassword(Util.md5(user.getPassword()));
            uRepo.save(user);
            hm.put("status",true);
            hm.put("user",user);
        }


        return new ResponseEntity<>(hm,HttpStatus.OK);
    }


    public ResponseEntity login(User user ) {
        Map<String, Object> hm = new LinkedHashMap<>();
        String newPass = Util.md5(user.getPassword());
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

    public ResponseEntity update( User user ) {
        Map<String, Object> hm = new HashMap<>();
        Optional<User> oUser = uRepo.findById(user.getUid());
        if ( oUser.isPresent() ) {
            uRepo.saveAndFlush(user);
            hm.put("message", user);
            hm.put("status", true);
        }else {
            hm.put("message", "Fail uid");
            hm.put("status", false);
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
