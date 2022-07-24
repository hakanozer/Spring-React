package com.works.restcontrollers;

import com.works.entities.Player;
import com.works.services.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PlayerRestController {

    final PlayerService pService;

    public PlayerRestController(PlayerService pService) {
        this.pService = pService;
    }

    @PostMapping("/footballerRegister")
    public ResponseEntity register( @RequestBody Player player ) {
        return pService.footballerRegister( player );
    }

}
