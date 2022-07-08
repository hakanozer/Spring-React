package com.example.tekrarcalisma.services;

import com.example.tekrarcalisma.entities.NewUserPerson;
import com.example.tekrarcalisma.entities.UserPerson;
import com.example.tekrarcalisma.repositories.UserPersonRepository;
import com.example.tekrarcalisma.utils.ERest;
import com.example.tekrarcalisma.utils.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserPersonService {


    final UserPersonRepository uRepo;

    public UserPersonService(UserPersonRepository uRepo) {
        this.uRepo= uRepo;
    }

    public ResponseEntity  register (UserPerson userPerson) {
        boolean singStatus = uRepo.existsByEmailEqualsAllIgnoreCase( userPerson.getEmail() );
        Map<ERest, Object> hm = new LinkedHashMap<>();

        if ( singStatus ){
            hm.put(ERest.status ,false);
            hm.put(ERest.message , "Bu kullanıcı emaili daha önce kayıtlı!");
        }else{
            userPerson.setPassword(Util.md5( userPerson.getPassword()));
            hm.put(ERest.status ,true);
            uRepo.save( userPerson);
            hm.put(ERest.result, userPerson);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity Login(UserPerson userPerson){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        String newPass = Util.md5(userPerson.getPassword());
        Optional<UserPerson> optionalUserPerson = uRepo.findByEmailEqualsAndPasswordEquals(userPerson.getEmail(),newPass);
        if (optionalUserPerson.isPresent()){
            hm.put(ERest.status, true);
            hm.put(ERest.message, "Login Success");
            UserPerson userPerson1 = optionalUserPerson.get();
            userPerson1.setPassword("secure");
            hm.put(ERest.result, optionalUserPerson.get());
        }else {
            hm.put(ERest.status,false);
            hm.put(ERest.message,"Login Failed.Try Again");
        }
        return new ResponseEntity(hm, HttpStatus.OK);

    }
    public ResponseEntity Settings(UserPerson userPerson){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Optional<UserPerson> optionalUserPerson = uRepo.findById(userPerson.getUid());
        if ( optionalUserPerson.isPresent() ) {
            UserPerson dbUserPerson = optionalUserPerson.get();
            dbUserPerson.setName(userPerson.getName());
            dbUserPerson.setSurname(userPerson.getSurname());
            dbUserPerson.setEmail(userPerson.getEmail());
            uRepo.saveAndFlush(dbUserPerson);
            dbUserPerson.setPassword("secure");
            hm.put(ERest.status, true);
            hm.put(ERest.result, dbUserPerson);
        }else {
            hm.put(ERest.message, "ID Fail");
            hm.put(ERest.status, false);
            hm.put(ERest.result, userPerson);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }
    public ResponseEntity passwordChange(NewUserPerson newUserPerson){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Optional<UserPerson> oUserPerson = uRepo.findById(newUserPerson.getUid());
        if ( oUserPerson.isPresent() ) {
            UserPerson dbUserPerson = oUserPerson.get();
            if (dbUserPerson.getPassword().equals(Util.md5(newUserPerson.getOldPass()))){
                String jsonNewPassword = Util.md5(newUserPerson.getNewPass());
                dbUserPerson.setPassword( jsonNewPassword );
                uRepo.saveAndFlush( dbUserPerson );
                hm.put(ERest.status, true);
                dbUserPerson.setPassword("secure");
                hm.put(ERest.result, dbUserPerson);
            }else {
                hm.put(ERest.status, false);
                hm.put(ERest.result, newUserPerson);
            }
        }else {
            hm.put(ERest.status, false);
            hm.put(ERest.result, newUserPerson);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }






}
