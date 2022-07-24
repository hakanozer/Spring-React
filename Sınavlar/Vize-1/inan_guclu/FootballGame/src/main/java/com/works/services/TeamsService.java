package com.works.services;

import com.works.entities.Gamer;
import com.works.repositories.GamerRepository;
import com.works.repositories.JoinTeamGamerRepository;
import com.works.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class TeamsService {

    final GamerRepository gamerRepository;
    final JoinTeamGamerRepository joinTeamGamerRepository;

    public TeamsService(GamerRepository gamerRepository, JoinTeamGamerRepository joinTeamGamerRepository) {

        this.gamerRepository = gamerRepository;
        this.joinTeamGamerRepository = joinTeamGamerRepository;
    }


    public ResponseEntity teamInsertA(int gamerID, int tID) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Optional<Gamer> gamer = gamerRepository.findById(gamerID);
        if (joinTeamGamerRepository.allGamer().size() < 16) {
            if (gamer.isPresent()) {
                Gamer dbgamer = gamer.get();
                dbgamer.setTeamID(tID);
                gamerRepository.saveAndFlush(dbgamer);
                hm.put(ERest.status, true);
                hm.put(ERest.result, gamer);

            } else {
                hm.put(ERest.status, false);

            }
        } else {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "takım doldu");

        }


        return new ResponseEntity(hm, HttpStatus.OK);

    }
    public ResponseEntity teamInsertB(int gamerID, int tID) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Optional<Gamer> gamer = gamerRepository.findById(gamerID);
        if (joinTeamGamerRepository.allGamer().size() < 16) {
            if (gamer.isPresent()) {
                Gamer dbgamer = gamer.get();
                dbgamer.setTeamID(tID);
                gamerRepository.saveAndFlush(dbgamer);
                hm.put(ERest.status, true);
                hm.put(ERest.result, gamer);

            } else {
                hm.put(ERest.status, false);

            }
        } else {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "takım doldu");

        }


        return new ResponseEntity(hm, HttpStatus.OK);

    }


    public ResponseEntity teamCreate () {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.status, true);

        return new ResponseEntity(hm, HttpStatus.OK);
    }

        public ResponseEntity backUpCreate () {
            Map<ERest, Object> hm = new LinkedHashMap<>();
            return new ResponseEntity(hm, HttpStatus.OK);
        }


    }
