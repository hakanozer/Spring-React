package com.works.services;

import com.works.etities.Footballer;
import com.works.etities.Team;
import com.works.repositories.TRepository;
import com.works.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class TService {
    final TRepository tRepository;

    public TService(TRepository tRepository) {
        this.tRepository = tRepository;
    }

    public ResponseEntity teamInsert(Team team) {
        Map<String, Object> hm = new LinkedHashMap<>();

        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity createTeam(Team team) {
        Map<String, Object> hm = new LinkedHashMap<>();
        Team team1=tRepository.save( team );
        hm.put("status", true);
        hm.put("result", team1);
        return new ResponseEntity(hm, HttpStatus.OK);
    }


  /*

    public ResponseEntity backUpCreate() {
        Map<String, Object> hm = new LinkedHashMap<>();
        tRepository.save(teams);
        hm.put("status", true);
        hm.put("result", teams);
        return new ResponseEntity(hm, HttpStatus.OK);
    }*/

}
