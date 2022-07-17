package com.works.tekrarproject.services;

import com.works.tekrarproject.entities.UserPassword;
import com.works.tekrarproject.entities.UserPerson;
import com.works.tekrarproject.repositories.UserPersonRepository;
import com.works.tekrarproject.utils.ERest;
import com.works.tekrarproject.utils.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class UserPersonService  {

    final UserPersonRepository upRepo;

    public UserPersonService(UserPersonRepository upRepo) { // construction initializer
        this.upRepo = upRepo;
    }

    public ResponseEntity register( UserPerson userPerson ) {
        boolean singStatus = upRepo.existsByEmailEqualsIgnoreCase( userPerson.getEmail() );
        // daha önce giriş olup olmadığının kontrolü yapılır
        // exist kullanıldığı için zaten 2 sonuç dönüyor o yüzden de optional kullanmaya gerek kalmıyor
        // eğer object(Entity bekleseydik) optional kesinlikle tavsiyemiz olurdu
        Map<ERest, Object> hm = new LinkedHashMap<>();
        if ( singStatus ) {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Bu kullanıcı email'i daha önceden kaydedilmiş");
        }else {
            userPerson.setPassword(Util.md5( userPerson.getPassword() ));
            hm.put(ERest.status, true);
            upRepo.save( userPerson );
            hm.put(ERest.result, userPerson);
        }
        return new ResponseEntity<>( hm, HttpStatus.OK);
    }

    public ResponseEntity settings( UserPerson userPerson ) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Optional<UserPerson> oUserPerson = upRepo.findById( userPerson.getUid() );
        // ilgili data'nın var olup olmadığı kontrol edildi
        if (oUserPerson.isPresent()) {
            UserPerson dbUserPerson = oUserPerson.get(); // safi UserPerson data'sı elde edildi
            dbUserPerson.setName( userPerson.getName() );
            dbUserPerson.setSurname( userPerson.getSurname() );
            dbUserPerson.setEmail( userPerson.getEmail() );
            upRepo.saveAndFlush( dbUserPerson );
            dbUserPerson.setPassword( "secur" );
            hm.put(ERest.status, true);
            hm.put(ERest.result, dbUserPerson);
        }else {
            hm.put(ERest.status, false);
            hm.put(ERest.result, userPerson);
        }
        return new ResponseEntity<>( hm, HttpStatus.OK);
    }

    public ResponseEntity passwordChange( UserPassword userPassword ) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Optional<UserPerson> oUserPerson = upRepo.findById( userPassword.getUid() );
        if (oUserPerson.isPresent()) {
            UserPerson dbUserPerson = oUserPerson.get();
            String dbOldPassword = dbUserPerson.getPassword();
            String jsonOldPassword = Util.md5(userPassword.getOldPassword());
            if (dbOldPassword.equals(jsonOldPassword)) {
                String jsonNewPassword = Util.md5( userPassword.getNewPassword() );
                dbUserPerson.setPassword( jsonNewPassword );
                upRepo.saveAndFlush( dbUserPerson );
                dbUserPerson.setPassword( "secur" );
                hm.put(ERest.status, true);
                hm.put(ERest.result, dbUserPerson);
            }else {
                hm.put(ERest.status, false);
                hm.put(ERest.result, userPassword);
            }
        }else {
            hm.put(ERest.status, false);
            hm.put(ERest.result, userPassword);
        }
        return new ResponseEntity<>( hm, HttpStatus.OK);
    }


}
