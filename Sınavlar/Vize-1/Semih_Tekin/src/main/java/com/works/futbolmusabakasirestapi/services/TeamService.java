package com.works.futbolmusabakasirestapi.services;

import com.works.futbolmusabakasirestapi.entities.Team;
import com.works.futbolmusabakasirestapi.repositories.TeamRepository;
import com.works.futbolmusabakasirestapi.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeamService {

    final TeamRepository teamRepository;
    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public ResponseEntity save(Team team){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        teamRepository.save(team);
        hm.put(ERest.status, true);
        hm.put(ERest.result, team);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list(){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.status, true);
        hm.put(ERest.result, teamRepository.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity teams(int tid){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        List<Team> teams = teamRepository.teams(tid);
        if (tid == 1){
            hm.put(ERest.status, true);
            hm.put(ERest.result, teams);
        } else if (tid == 2) {
            hm.put(ERest.status, true);
            hm.put(ERest.result, teams);
        }else {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Yanliş tid girdiniz.");
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }


}
