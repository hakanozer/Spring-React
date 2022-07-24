package com.works.restcontrollers;

import com.works.entities.Player;
import com.works.entities.TeamsPlayer;
import com.works.services.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/new")
public class PlayerRestController {
    final PlayerService pService;

    public PlayerRestController(PlayerService pService) {
        this.pService = pService;
    }

    @PostMapping("/player")
    public ResponseEntity profileUpdate(@RequestBody Player player) {
        return pService.footballerRegister(player);
    }

    @PostMapping("/team")
    public ResponseEntity teamInsert(@RequestBody TeamsPlayer teamsPlayer){
        return pService.teamsInsert(teamsPlayer);
    }


}
