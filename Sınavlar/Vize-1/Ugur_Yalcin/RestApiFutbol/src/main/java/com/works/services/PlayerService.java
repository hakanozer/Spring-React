package com.works.services;

import com.works.entities.Player;
import com.works.entities.TeamsJoin;
import com.works.repositories.PlayerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class PlayerService {

    final PlayerRepository pRepo;


    public PlayerService(PlayerRepository pRepo) {
        this.pRepo = pRepo;
    }

    public ResponseEntity save(Player player) {
        Map<String, Object> hm = new LinkedHashMap<>();
        try{
            pRepo.save(player);
            hm.put("success", true);
            hm.put("Player ID", player.getPid());
        }catch (Exception e) {
            hm.put("status", false);
            hm.put("message", "Error");
            return new ResponseEntity(hm, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list() {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        hm.put("result", pRepo.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
