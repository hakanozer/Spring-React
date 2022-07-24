package com.works.services;

import com.works.entities.Gamer;
import com.works.repositories.GamerRepository;
import com.works.utils.ERest;
import com.works.utils.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class GamerService {

    final GamerRepository gamerRepository;
    final TeamsService teamsService;



    public GamerService(GamerRepository gamerRepository, TeamsService teamsService) {
        this.gamerRepository = gamerRepository;

        this.teamsService = teamsService;
    }


    public ResponseEntity gamerRegister(Gamer gamer) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        String newPass = Util.md5(gamer.getPassword());
        gamer.setPassword(newPass);
        Optional<Gamer> myGamer= Optional.ofNullable(gamerRepository.findByEmailEqualsIgnoreCase(gamer.getEmail()));
        if (myGamer.isPresent()){
            hm.put(ERest.status,false);
            hm.put(ERest.message,"aynı mail olamaz..");
        }else{
            if (gamer.getTeams().getTeamName().toLowerCase().equals("Red")){
                gamerRepository.saveAndFlush(gamer);
                teamsService.teamInsertA(gamer.getGamerID(), gamer.getTeamID());
                hm.put(ERest.status, true);
                hm.put(ERest.result, gamer);

            }
        }

        gamerRepository.save(gamer);
        hm.put(ERest.status, true);
        hm.put(ERest.result, gamer);

        return new ResponseEntity(hm, HttpStatus.OK);

    }





}
