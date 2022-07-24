package com.example.futbolrestapi.services;

import com.example.futbolrestapi.entities.Teams;
import com.example.futbolrestapi.repositories.JoinFutbolcuTakimRepository;
import com.example.futbolrestapi.repositories.TRepository;
import com.example.futbolrestapi.utils.ENumRest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class TService {

    final JoinFutbolcuTakimRepository joinFutbolcuTakimRepository;
    final TRepository tRepo;
    public TService(JoinFutbolcuTakimRepository joinFutbolcuTakimRepository, TRepository tRepo) {
        this.joinFutbolcuTakimRepository = joinFutbolcuTakimRepository;
        this.tRepo = tRepo;
    }


    public ResponseEntity save(Teams teams){
        Map<ENumRest,Object> hm = new LinkedHashMap<>();
        hm.put(ENumRest.status,true);
        hm.put(ENumRest.result,tRepo.save(teams));
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list(){
        Map<ENumRest,Object> hm = new LinkedHashMap<>();
        hm.put(ENumRest.status,true);
        hm.put(ENumRest.result,tRepo.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }
    public ResponseEntity teamInsert(Teams teams){
        Map<ENumRest, Object> hm = new LinkedHashMap<>();





        return new ResponseEntity(hm, HttpStatus.OK);

    }




}
