package com.works.services;

import com.works.entities.UserPerson;
import com.works.repositories.UserPersonRepository;
import com.works.utils.ERest;
import com.works.utils.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class UserPersonService {

    final UserPersonRepository uRepo;
    public UserPersonService(UserPersonRepository uRepo) {
        this.uRepo = uRepo;
    }

    public ResponseEntity register(  UserPerson userPerson) {
        boolean singStatus = uRepo.existsByEmailEqualsAllIgnoreCase( userPerson.getEmail() );
        Map<ERest, Object> hm = new LinkedHashMap<>();
        if ( singStatus ) {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Bu kullanıcı emaili daha önce kayıtlı");
        }else {
            userPerson.setPassword( Util.md5( userPerson.getPassword() ));
            hm.put(ERest.status, true);
            uRepo.save( userPerson );
            hm.put( ERest.result, userPerson );
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }


}
