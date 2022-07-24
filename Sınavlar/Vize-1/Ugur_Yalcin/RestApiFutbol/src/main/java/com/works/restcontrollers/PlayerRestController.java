package com.works.restcontrollers;

import com.works.entities.Player;
import com.works.services.PlayerService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Player")
public class PlayerRestController {

    final PlayerService pService;
    public PlayerRestController(PlayerService pService) {
        this.pService = pService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@Validated @RequestBody Player player) {
        return pService.save( player );
    }

    @GetMapping("/list")
    public ResponseEntity list(){
        return pService.list();
    }

}
