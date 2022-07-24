package com.works.services;

import com.works.entities.Footballer;
import com.works.repositories.FootballerRepository;
import com.works.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@Service
public class FootballerService {

    public List<Footballer> ls = new ArrayList<>();
    final FootballerRepository fRepo;

    public FootballerService(FootballerRepository fRepo) {
        this.fRepo = fRepo;
    }

    public ResponseEntity save(Footballer footballer) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        //ls.add(footballer);
        fRepo.save(footballer);
        hm.put(ERest.status, true);
        hm.put(ERest.result, footballer);
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
