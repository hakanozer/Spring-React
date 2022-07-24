package com.works.services;

import com.works.Utils.Util;
import com.works.entities.Player;
import com.works.entities.TeamsPlayer;
import com.works.repositories.PlayerRepository;
import com.works.repositories.TeamsPlayerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class PlayerService {
    final PlayerRepository pRepo;
    final TeamsPlayerRepository tRepo;

    public PlayerService(PlayerRepository pRepo, TeamsPlayerRepository tRepo) {
        this.pRepo = pRepo;
        this.tRepo = tRepo;
    }

    public ResponseEntity footballerRegister(Player player) {
        Map<String, Object> hm = new LinkedHashMap<>();
        String newPass = Util.md5(player.getPassword());
        player.setPassword(newPass);
        pRepo.save(player);
        hm.put("status", true);
        hm.put("result", player);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity teamsInsert(TeamsPlayer teamsPlayer){
        Map<String, Object> hm = new LinkedHashMap<>();
        if(pRepo.existsByPidEquals(teamsPlayer.getPid())) {
            if (!tRepo.existsByPidEquals(teamsPlayer.getPid())) {
                tRepo.save(teamsPlayer);
                hm.put("status", true);
                hm.put("result", teamsPlayer);
            } else {
                hm.put("status", false);
                hm.put("message", "Oyuncu bir takıma zaten üye");
            }
        }else{
            hm.put("status", false);
            hm.put("message", "Böyle bir oyuncu yok");
        }

        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
