package com.works.services;

import com.works.entities.Player;
import com.works.entities.Teams;
import com.works.repositories.TeamsRepository;
import com.works.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class TeamsService {

    final TeamsRepository tRepo;

    public TeamsService(TeamsRepository tRepo) {
        this.tRepo = tRepo;
    }

    public ResponseEntity teamInsert( Teams teams ) {
        Map<ERest, Object> hm = new LinkedHashMap<>();

        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity save( Teams teams ) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.status, true);
        hm.put(ERest.result, tRepo.save(teams));
        return new ResponseEntity( hm, HttpStatus.OK );
    }

    public ResponseEntity list(){
        Map<ERest,Object> hm = new LinkedHashMap<>();
        hm.put(ERest.status, true);
        hm.put(ERest.result, tRepo.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
