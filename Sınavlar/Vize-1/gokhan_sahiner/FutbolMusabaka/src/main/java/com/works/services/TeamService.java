package com.works.services;

import com.works.entities.Player;
import com.works.repositories.PlayerRepository;
import com.works.repositories.TeamsPlayerRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeamService {


    final TeamsPlayerRepository tRepo;
    final PlayerRepository pRepo;

    public TeamService(TeamsPlayerRepository tRepo, PlayerRepository pRepo) {
        this.tRepo = tRepo;
        this.pRepo = pRepo;
    }

    public ResponseEntity teamPlayers() {
        Map<String, Object> hm = new LinkedHashMap<>();
        List<Player> teamA = pRepo.listPlayer(1,0,11);
        List<Player> teamB = pRepo.listPlayer(2,0,11);
        hm.put("status", true);
        hm.put("team A", teamA);
        hm.put("team B", teamB);
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity backUpPlayers() {
        Map<String, Object> hm = new LinkedHashMap<>();
        List<Player> teamA = pRepo.listPlayer(1,11,5);
        List<Player> teamB = pRepo.listPlayer(2,11,5);
        hm.put("status", true);
        hm.put("team A", teamA);
        hm.put("team B", teamB);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
