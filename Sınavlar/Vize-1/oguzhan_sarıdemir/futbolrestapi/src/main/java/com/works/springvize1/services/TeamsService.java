package com.works.springvize1.services;

import com.works.springvize1.entities.Player;
import com.works.springvize1.entities.Teams;
import com.works.springvize1.repository.TeamsRepository;
import com.works.springvize1.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeamsService {
    final TeamsRepository tRepo;

    public TeamsService(TeamsRepository tRepo) {
        this.tRepo = tRepo;
    }
    public ResponseEntity getAs() {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        List<Player> player= tRepo.findByIstekContainsIgnoreCaseOrderByAgeAsc("Teams");

        for (int i=0; i<11;  i++)
        {

            player.add(player.get(i));
        }
        hm.put(ERest.status, true);

        return new ResponseEntity(hm, HttpStatus.OK);

    }
    public ResponseEntity getall(Teams teams) {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        hm.put("users", tRepo.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);

    }


    public ResponseEntity list() {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.status, true);
        hm.put(ERest.result, tRepo.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);


    }

}
