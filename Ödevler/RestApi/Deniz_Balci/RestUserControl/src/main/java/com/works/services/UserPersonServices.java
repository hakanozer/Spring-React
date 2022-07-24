package com.works.services;

import com.works.entities.UserPerson;
import com.works.entities.UserPersonPasswordChange;
import com.works.repositories.UserPersonRepository;
import com.works.utils.ERest;
import com.works.utils.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserPersonServices {

    final UserPersonRepository userPersonRepository;

    public UserPersonServices(UserPersonRepository userPersonRepository) {
        this.userPersonRepository = userPersonRepository;
    }

    public ResponseEntity register (UserPerson userPerson){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        if (userPerson.getName().length()<3 || userPerson.getName().length()>13 ){
            hm.put(ERest.status,false);
            hm.put(ERest.message,"Name must be between 3 to 13 charters");
        } else if (userPerson.getSurname().length()<3 || userPerson.getSurname().length()>13) {
            hm.put(ERest.status,false);
            hm.put(ERest.message,"Surname must be between 3 to 13 charters");
        } else if (userPersonRepository.findByEmailEquals(userPerson.getEmail()).isPresent()){
        hm.put(ERest.status,false);
        hm.put(ERest.message,userPerson.getEmail()+" is pre-registered");
        } else {
            userPerson.setPassword(Util.md5(userPerson.getPassword()));
            hm.put(ERest.status,true);
            hm.put(ERest.message,userPerson.getEmail()+" Registered");
            hm.put(ERest.result, userPersonRepository.save(userPerson));
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity login (UserPerson userPerson){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        String turnMd5Pass = Util.md5(userPerson.getPassword());
        if (userPersonRepository.findByEmailEqualsAndPasswordEqualsAllIgnoreCase(userPerson.getEmail(), turnMd5Pass).isPresent()){

        hm.put(ERest.status,true);
        hm.put(ERest.message, "Login Success");
        String sPass = "";
        for (int i = 0 ; i<userPerson.getPassword().length(); i++){
            sPass="*"+sPass;
        }
        UserPerson loginPerson =userPersonRepository.findByEmailEqualsAndPasswordEqualsAllIgnoreCase(userPerson.getEmail(),turnMd5Pass).get();
        loginPerson.setPassword(sPass);
        hm.put(ERest.result, loginPerson);
        } else {
            hm.put(ERest.status,false);
            hm.put(ERest.message,"Email or Password Fail");
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity update ( UserPerson userPerson){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        if (userPersonRepository.findByUidEquals(userPerson.getUid()).isPresent()){
            if (userPerson.getName().length()<3 || userPerson.getName().length()>13 ){
                hm.put(ERest.status,false);
                hm.put(ERest.message,"Name must be between 3 to 13 charters");
            } else if (userPerson.getSurname().length()<3 || userPerson.getSurname().length()>13) {
                hm.put(ERest.status,false);
                hm.put(ERest.message,"Surname must be between 3 to 13 charters");
            } else {
                userPerson.setPassword(Util.md5(userPerson.getPassword()));
                userPersonRepository.saveAndFlush(userPerson);
                hm.put(ERest.status,true);
                hm.put(ERest.message, "Id :"+userPerson.getUid()+"'s information has been updated");
                hm.put(ERest.result, userPerson);
            }
        } else {
        hm.put(ERest.status,false);
        hm.put(ERest.message,"uid Fail");
    }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity changePassword (UserPersonPasswordChange userPersonPasswordChange){
        Map<ERest, Object> hm = new LinkedHashMap<>();
            String turnOldPassToMd5 = Util.md5(userPersonPasswordChange.getPassword());
            Optional<UserPerson> optionalUserPerson =userPersonRepository.findByEmailEqualsAndPasswordEqualsAllIgnoreCase(userPersonPasswordChange.getEmail(),turnOldPassToMd5);
            if (optionalUserPerson.isPresent()){
                UserPerson userPerson =optionalUserPerson.get();
                userPerson.setPassword(Util.md5(userPersonPasswordChange.getNewPassword()));
                userPersonRepository.saveAndFlush(userPerson);
                hm.put(ERest.status,true);
                hm.put(ERest.message, "You changed your password");
                hm.put(ERest.result, userPerson);
            }else {
                hm.put(ERest.status,false);
                hm.put(ERest.message,"Email or Password Fail");
            }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
