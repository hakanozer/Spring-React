package com.works.services;

import com.works.entities.Footballer;
import com.works.repositories.FootballerRepository;
import com.works.utils.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class FootballerService {

    final FootballerRepository fRepo;

    public FootballerService(FootballerRepository fRepo) {
        this.fRepo = fRepo;
    }
    public ResponseEntity save(Footballer footballer) {
        Map<String, Object> hm = new LinkedHashMap<>();
        String newPass = Util.md5(footballer.getPassword());
        footballer.setPassword(newPass);
        fRepo.save(footballer);
        hm.put("status", true);
        hm.put("result", footballer);
        hm.put("uid",footballer.getFid());
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list() {
        Map<String,Object> hm = new LinkedHashMap<>();
        hm.put("status",true);
        hm.put("result",fRepo.findAll());
        return new ResponseEntity(hm,HttpStatus.OK);
    }
}
