package com.works.services;

import com.works.entities.User;
import com.works.repositories.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {

    final UserRepository uRepo;
    public UserService(UserRepository uRepo) {
        this.uRepo = uRepo;
    }


    public ResponseEntity save( User user) {
        Map<String, Object> hm = new HashMap<>();
        User u = uRepo.save(user);
        System.out.println( "u :" + u.getClass().hashCode() );
        System.out.println( "user :" + user.getClass().hashCode() );
        hm.put("user", user);
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity list() {
        Map<String, Object> hm = new HashMap<>();
        hm.put("users", uRepo.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity delete( String id ) {
        Map<String, Object> hm = new HashMap<>();
        try {
            int iid = Integer.parseInt(id);
            uRepo.deleteById(iid);
            hm.put("status", true);
        }catch (Exception ex) {
            hm.put("message", "id request : " + id);
            hm.put("status", false);
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity single( String sid ) {
        Map<String, Object> hm = new HashMap<>();
        try {
            int id = Integer.parseInt(sid);
            Optional<User> oUser = uRepo.findById(id);
            if (oUser.isPresent() ) {
                // bu user var
                hm.put("status", true);
                hm.put("result", oUser.get() );
            }else {
                hm.put("status", false);
                hm.put("result", "Empty!" );
            }
        }catch (Exception ex) {
            hm.put("message", "id request : " + sid);
            hm.put("status", false);
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
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

}
