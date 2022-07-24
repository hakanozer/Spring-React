package com.work.services;

import com.work.entities.NewPerson;
import com.work.entities.UserPerson;
import com.work.respository.UserRespository;
import com.work.utils.ERest;
import com.work.utils.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserServices {

    final UserRespository userRespository;

    public UserServices(UserRespository userRespository) {

        this.userRespository = userRespository;
    }

    public ResponseEntity  register (UserPerson userPerson) {
        boolean singStatus = userRespository.existsByEmailEqualsAllIgnoreCase( userPerson.getEmail() );
        Map<ERest, Object> hm = new LinkedHashMap<>();

        if ( singStatus ){
            hm.put(ERest.status ,false);
            hm.put(ERest.message , "Bu kullanıcı emaili daha önce kayıtlı!");
        }else{
            userPerson.setPassword(Util.md5( userPerson.getPassword()));
            hm.put(ERest.status ,true);
            userRespository.save( userPerson);
            hm.put(ERest.result, userPerson);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity userLogin(UserPerson userPerson){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        String newPass = Util.md5(userPerson.getPassword());
        Optional<UserPerson> optionalUserPerson = userRespository.findByEmailEqualsAndPasswordEquals(userPerson.getEmail(),newPass);
        if (optionalUserPerson.isPresent()){
            hm.put(ERest.status, true);
            hm.put(ERest.message, "Girişiniz Başarılı!");
            UserPerson userPerson1 = optionalUserPerson.get();
            userPerson1.setPassword("secur");
            hm.put(ERest.result, optionalUserPerson.get());
        }else {
            hm.put(ERest.status,false);
            hm.put(ERest.message,"Girişiniz başarısız. Lütfen yeniden deneyiniz!");
        }
        return new ResponseEntity(hm, HttpStatus.OK);

    }
    public ResponseEntity updateSettings(UserPerson userPerson){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Optional<UserPerson> optionalUserPerson = userRespository.findById(userPerson.getUid());
        if ( optionalUserPerson.isPresent() ) {
            UserPerson dbUserPerson = optionalUserPerson.get();
            dbUserPerson.setName(userPerson.getName());
            dbUserPerson.setSurname(userPerson.getSurname());
            dbUserPerson.setEmail(userPerson.getEmail());
            userRespository.saveAndFlush(dbUserPerson);
            dbUserPerson.setPassword("secur");
            hm.put(ERest.status, true);
            hm.put(ERest.result, dbUserPerson);
        }else {
            hm.put(ERest.message, "Hatalı id");
            hm.put(ERest.status, false);
            hm.put(ERest.result, userPerson);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }
    public ResponseEntity passwordChange(NewPerson newPerson){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Optional<UserPerson> oUserPerson = userRespository.findById(newPerson.getUid());
        if ( oUserPerson.isPresent() ) {
            UserPerson dbUserPerson = oUserPerson.get();
            if (dbUserPerson.getPassword().equals(Util.md5(newPerson.getOldPass()))){
                String jsonNewPassword = Util.md5(newPerson.getNewPass());
                dbUserPerson.setPassword( jsonNewPassword );
                userRespository.saveAndFlush( dbUserPerson );
                hm.put(ERest.status, true);
                dbUserPerson.setPassword("security");
                hm.put(ERest.result, dbUserPerson);
            }else {
                hm.put(ERest.status, false);
                hm.put(ERest.result, newPerson);
            }
        }else {
            hm.put(ERest.status, false);
            hm.put(ERest.result, newPerson);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}

