package com.example.services;

import com.example.entities.UserPerson;
import com.example.entities.UserPersonPassword;
import com.example.repositories.UserPersonRepository;
import com.example.utils.Erest;
import com.example.utils.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    final UserPersonRepository uRepo;

    public UserService(UserPersonRepository uRepo) {
        this.uRepo = uRepo;
    }


    public ResponseEntity register(UserPerson userPerson) {
        boolean singStatus = uRepo.existsByEmailEqualsAllIgnoreCase(userPerson.getEmail());
        Map<Erest, Object> hm = new LinkedHashMap<>();
       if (singStatus){
           hm.put(Erest.status,false);
           hm.put(Erest.message,"Bu kullanıcı emaili daha önce kayıtlı");

       }else {
           userPerson.setPassword(Util.md5(userPerson.getPassword()));
           hm.put(Erest.status,true);
          uRepo.save(userPerson);
          hm.put(Erest.result,userPerson);
       }
        return new ResponseEntity(hm, HttpStatus.OK);

    }

    public ResponseEntity login(UserPerson userPerson){
        Map<Erest,Object> hm = new LinkedHashMap<>();
        String newPass = Util.md5(userPerson.getPassword());
        Optional<UserPerson> oUserPerson = uRepo.findByEmailEqualsAndPasswordEquals(userPerson.getEmail(),newPass);
        if (oUserPerson.isPresent()){
            hm.put(Erest.status, true);
            hm.put(Erest.message, "Login Success");
            UserPerson u = oUserPerson.get();
            u.setPassword("security");
            hm.put(Erest.result, u );
        }else {
            hm.put(Erest.status, false);
            hm.put(Erest.message, "Email or Password Fail");
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity settings( UserPerson userPerson ) {
        Map<Erest, Object> hm = new LinkedHashMap<>();
        Optional<UserPerson> oUserPerson = uRepo.findById(userPerson.getUid());
        if ( oUserPerson.isPresent() ) {
            UserPerson dbUserPerson = oUserPerson.get();
            dbUserPerson.setName(userPerson.getName());
            dbUserPerson.setSurname(userPerson.getSurname());
            dbUserPerson.setEmail(userPerson.getEmail());
            uRepo.saveAndFlush(dbUserPerson);
            dbUserPerson.setPassword("security");
            hm.put(Erest.status, true);
            hm.put(Erest.result, dbUserPerson);
        }else {
            hm.put(Erest.message, "Fail uid");
            hm.put(Erest.status, false);
            hm.put(Erest.result, userPerson);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity passwordChange( UserPersonPassword userPersonPassword ) {
        Map<Erest, Object> hm = new LinkedHashMap<>();
        Optional<UserPerson> oUserPerson = uRepo.findById(userPersonPassword.getUid());
        if ( oUserPerson.isPresent() ) {
            UserPerson dbUserPerson = oUserPerson.get();
           if (dbUserPerson.getPassword().equals(Util.md5(userPersonPassword.getOldPassword()))){
               String jsonNewPassword = Util.md5( userPersonPassword.getNewPassword() );
               dbUserPerson.setPassword( jsonNewPassword );
               uRepo.saveAndFlush( dbUserPerson );
               hm.put(Erest.status, true);
               dbUserPerson.setPassword("security");
               hm.put(Erest.result, dbUserPerson);
           }else {
               hm.put(Erest.status, false);
               hm.put(Erest.result, userPersonPassword);
           }
        }else {
            hm.put(Erest.status, false);
            hm.put(Erest.result, userPersonPassword);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }
    }




