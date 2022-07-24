package com.works.services;

import com.works.entities.FootballPlayer;
import com.works.entities.JoinTeamPlayer;
import com.works.repositories.FootballPlayerRepository;
import com.works.repositories.JoinTeamPlayerRepository;
import com.works.utils.Erest;
import com.works.utils.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class FootballPlayerService {

    // Daha sonradan as takım ve yedek oyuncu sayılarını değiştirmek istersek kolaylık sağlaması için,
    final static int AGE_LIMIT = 18;
    final static int ACETEAM_PLAYERS= 11;
    final static int SUBSTITUTE_PLAYER = 5;


    final FootballPlayerRepository fRepo ;
    final JoinTeamPlayerRepository jRepo;

    public FootballPlayerService(FootballPlayerRepository fRepo, JoinTeamPlayerRepository jRepo) {
        this.fRepo = fRepo;
        this.jRepo = jRepo;
    }

    public ResponseEntity footballerRegister (FootballPlayer footballPlayer) {
        Map<Erest, Object> hm = new LinkedHashMap<>();
        if (footballPlayer.getAge() < AGE_LIMIT ) {
            hm.put(Erest.message, "Football Player Age must be min. 18");
            hm.put(Erest.status, "False");
        } else if (fRepo.findByEmailEquals(footballPlayer.getEmail()).isPresent()) {
            hm.put(Erest.status, "False");
            hm.put(Erest.message, "Football Player Email ("+footballPlayer.getEmail()+") is pre-registered");
        }else{
            footballPlayer.setPassword(Util.md5(footballPlayer.getPassword()));
            hm.put(Erest.status, "True");
            hm.put(Erest.result, fRepo.save(footballPlayer));
            hm.put(Erest.message, "Football Player register has saved successful and your id is :"+footballPlayer.getFid());

        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity teamCreate () {
        Map<Erest, Object> hm = new LinkedHashMap<>();
        List<JoinTeamPlayer> teamPlayers = new ArrayList<>();
        for (int i = 0; i < ACETEAM_PLAYERS; i++) {
            teamPlayers.add(jRepo.listTeam("%A%").get(i));
        }
        for (int i = 0; i < ACETEAM_PLAYERS; i++) {
            teamPlayers.add(jRepo.listTeam("%B%").get(i));
        }
        hm.put(Erest.status, "True");
        hm.put(Erest.result,teamPlayers);

        return new ResponseEntity(hm, HttpStatus.OK);

    }
    public ResponseEntity backUpCreate () {
        Map<Erest, Object> hm = new LinkedHashMap<>();
        List<JoinTeamPlayer> teamPlayers = new ArrayList<>();
        for (int i = ACETEAM_PLAYERS; i < ACETEAM_PLAYERS+SUBSTITUTE_PLAYER; i++) {
            teamPlayers.add(jRepo.listTeam("%A%").get(i));
        }
        for (int i = ACETEAM_PLAYERS; i < ACETEAM_PLAYERS+SUBSTITUTE_PLAYER; i++) {
            teamPlayers.add(jRepo.listTeam("%B%").get(i));
        }
        hm.put(Erest.status, "True");
        hm.put(Erest.result,teamPlayers);

        return new ResponseEntity(hm, HttpStatus.OK);

    }

}
