package com.works.services;

import com.works.entities.Teamss;
import com.works.repositories.TeamsRepository;
import com.works.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class TeamsService {

    final TeamsRepository teamsRepository;

    public TeamsService(TeamsRepository teamsRepository) {
        this.teamsRepository = teamsRepository;
    }


    public ResponseEntity save(Teamss teams){
        Map<ERest,Object> hm = new LinkedHashMap<>();
        hm.put(ERest.status,true);
        hm.put(ERest.result,teamsRepository.save(teams));
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list(){
        Map<ERest,Object> hm = new LinkedHashMap<>();
        hm.put(ERest.status,true);
        hm.put(ERest.result,teamsRepository.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }


}
