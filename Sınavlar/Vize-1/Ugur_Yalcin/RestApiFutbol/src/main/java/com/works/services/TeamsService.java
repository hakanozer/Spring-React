package com.works.services;

import com.works.entities.Teams;
import com.works.entities.TeamsJoin;
import com.works.repositories.TeamsRepository;
import com.works.utils.REnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.LinkedHashMap;
import java.util.Map;

public class TeamsService {

    final TeamsRepository tRepo;
    final TeamsJoin jRepo;

    public TeamsService(TeamsRepository tRepo, TeamsJoin jRepo) {
        this.tRepo = tRepo;
        this.jRepo = jRepo;
    }


    public ResponseEntity save(Teams teams){
        Map<REnum,Object> hm = new LinkedHashMap<>();
        hm.put(REnum.status,true);
        hm.put(REnum.result,tRepo.save(teams));
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list(){
        Map<REnum,Object> hm = new LinkedHashMap<>();
        hm.put(REnum.status,true);
        hm.put(REnum.result,tRepo.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
