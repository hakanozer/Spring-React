package com.works.springvize1.services;

import com.works.springvize1.entities.Player;
import com.works.springvize1.entities.Teams;
import com.works.springvize1.repository.PlayerRepository;
import com.works.springvize1.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class PlayerService {
    final PlayerRepository pRepo;

    public PlayerService(PlayerRepository pRepo) {
        this.pRepo = pRepo;
    }

    public ResponseEntity save(Player player) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        if (player.getAge() >= 18) {
            pRepo.save(player);
            hm.put(ERest.status, true);
            hm.put(ERest.result, player);

        } else {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "18 yaşından küçükseniz kayit olamazsınız");
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity getAll() {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        hm.put("result", pRepo.findAll());

        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity search(String q) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.status, true);
        hm.put(ERest.result, pRepo.findById(Integer.valueOf("%" + q + "%")));
        return new ResponseEntity(hm, HttpStatus.OK);

    }
}
