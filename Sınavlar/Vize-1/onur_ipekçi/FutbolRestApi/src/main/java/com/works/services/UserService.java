package com.works.services;

import com.works.entities.JoinTeamsUser;
import com.works.entities.User;
import com.works.repositories.JoinTeamsUserRepository;
import com.works.repositories.UserRepository;
import com.works.utils.ERest;
import com.works.utils.Util;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    final JoinTeamsUserRepository jRepo;



    public UserService(UserRepository uRepo, JoinTeamsUserRepository jRepo) {
        this.uRepo = uRepo;

        this.jRepo = jRepo;
    }

    public ResponseEntity footballerRegister(User user) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        if (user.getAge()>=18){
            String newPass = Util.md5(user.getPassword());
            user.setPassword(newPass);
            uRepo.save(user);
            hm.put(ERest.status, true);
            hm.put(ERest.result, user );

        }else {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Giriş için 18 yaşından büyük olmanız gerekmektedir" );
        }
        return new ResponseEntity(hm, HttpStatus.OK);

    }

    public ResponseEntity teamInsert(JoinTeamsUser joinTeamsUser) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        boolean used =jRepo.existsByFidEquals(joinTeamsUser.getFid());
        Optional<User> oUser = uRepo.findByFidEquals(joinTeamsUser.getFid());
        if (!used&&oUser.isPresent()){
            jRepo.save(joinTeamsUser);
            hm.put(ERest.status, true);
            hm.put(ERest.result, joinTeamsUser );
            hm.put(ERest.message,"Kayıt Başarılı");
        }else if(used){
            hm.put(ERest.status, false);
            hm.put(ERest.message,"Bu oyuncunun bir takımı bulunmakta");
        }else {
            hm.put(ERest.status, false);
            hm.put(ERest.message,"Böyle bir oyuncu bulunmamakta.");
        }
        return new ResponseEntity(hm, HttpStatus.OK);

    }

}
