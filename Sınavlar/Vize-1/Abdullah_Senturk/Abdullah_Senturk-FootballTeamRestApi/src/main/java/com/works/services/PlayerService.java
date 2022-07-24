package com.works.services;

import com.works.entities.JoinPlayerTeams;
import com.works.entities.Player;
import com.works.repositories.JoinPlayerTeamsRepository;
import com.works.repositories.PlayerRepository;
import com.works.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class PlayerService {

    final PlayerRepository pRepo;
    final JoinPlayerTeamsRepository jRepo;

    public PlayerService(PlayerRepository pRepo, JoinPlayerTeamsRepository jRepo) {
        this.pRepo = pRepo;
        this.jRepo = jRepo;
    }

    public ResponseEntity footballerRegister( Player player ) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        if ( player.getFid() < 23) {
            pRepo.save( player );
            hm.put(ERest.status, true);
            hm.put(ERest.result, player);
        } else {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "The number of players cannot be greater than 22!");
        }
        return new ResponseEntity( hm, HttpStatus.OK );
    }

    public ResponseEntity teamInsert( int fid, int tid ) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Optional<Player> oPlayer = pRepo.findById( fid );
        if ( oPlayer.isPresent() ) {
            if ( jRepo.count(tid) <= 2 ) {
                Player dbPlayer = oPlayer.get();
                dbPlayer.setTid( tid );
                pRepo.saveAndFlush( dbPlayer );
                hm.put(ERest.status, true);
                hm.put(ERest.result, dbPlayer);
            }else {
                hm.put(ERest.status, false);
                hm.put(ERest.message, "The team is full!");
            }
        }
        return new ResponseEntity( hm, HttpStatus.OK );
    }





}
