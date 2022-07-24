package com.works.futbol.restcontrollers;

import com.works.futbol.entities.Player;
import com.works.futbol.services.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/player")
public class PlayerController {

    final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping("/all")
    public ResponseEntity getAll(){
        return  playerService.getAll();
    }

    @PostMapping("/save")
    public ResponseEntity save(@Validated @RequestBody Player player){
        return playerService.save(player);
    }
}
