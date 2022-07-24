package com.works.controllers;

import com.works.services.TeamsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teams")
public class TeamsRestController {
    final TeamsService teamsService;

    public TeamsRestController(TeamsService teamsService) {
        this.teamsService = teamsService;
    }

    @PostMapping("/getAllPlayers")
    public ResponseEntity getAllPlayers(@RequestParam int tid){
        return teamsService.getTeamPlayer(tid);
    }
}
