package com.works.restcontrollers;

import com.works.services.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamRestController {

    final TeamService tService;
    public TeamRestController(TeamService tService) {
        this.tService = tService;
    }


    @GetMapping("/players")
    public ResponseEntity teamPlayers(){
        return tService.teamPlayers();
    }

    @GetMapping("/backup")
    public ResponseEntity backUpPlayers(){
        return tService.backUpPlayers();
    }
}
