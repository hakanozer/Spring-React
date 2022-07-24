package com.works.services;

import com.works.entities.Footballer;
import com.works.entities.Team;
import com.works.repositories.TeamRepository;
import com.works.utils.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class TeamService {
    final TeamRepository tRepo;

    public TeamService(TeamRepository tRepo) {
        this.tRepo = tRepo;
    }


    public ResponseEntity save(Team team) {
        Map<String, Object> hm = new LinkedHashMap<>();

       tRepo.save(team);
        hm.put("status", true);
        hm.put("result", team);
        hm.put("uid",team.getTid());
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list() {
        Map<String,Object> hm = new LinkedHashMap<>();
        hm.put("status",true);
        hm.put("result",tRepo.findAll());
        return new ResponseEntity(hm,HttpStatus.OK);
    }
}
