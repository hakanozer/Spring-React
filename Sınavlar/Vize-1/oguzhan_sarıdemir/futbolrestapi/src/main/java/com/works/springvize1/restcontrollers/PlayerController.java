package com.works.springvize1.restcontrollers;


import com.works.springvize1.entities.Player;
import com.works.springvize1.services.PlayerService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PlayerController {
    final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @GetMapping("/save")
    public ResponseEntity save(@RequestBody Player player) {
        return playerService.save(player);
    }

    @GetMapping("/all")
    public ResponseEntity getAll() {
        return playerService.getAll();
    }

    List<Player> findByOrderByAgeAsc() {
        return null;
    }

    List<Player> findByIstekContainsIgnoreCaseOrderByAgeAsc(String istek) {
        return null;
    }
    @GetMapping("/search")
    public ResponseEntity search(@RequestParam(defaultValue = "") String q) {
        return playerService.search(q);
    }
    @GetMapping("/list")
    public ResponseEntity list() {
        return playerService.search("q");
    }

}
