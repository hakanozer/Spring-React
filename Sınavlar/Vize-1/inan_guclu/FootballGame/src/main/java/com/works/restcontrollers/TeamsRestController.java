package com.works.restcontrollers;

import com.works.entities.Teams;
import com.works.services.TeamsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamsRestController {

    final TeamsService teamsService;


    public TeamsRestController(TeamsService teamsService) {
        this.teamsService = teamsService;
    }



    @GetMapping("/teamInsert/A")
    public ResponseEntity teamInsertA(@RequestBody int gamerID, int tID ){
        return teamsService.teamInsertA(gamerID,tID);

    }
    @GetMapping("/teamInsert/B")
    public ResponseEntity teamInsertB(@RequestBody int gamerID, int tID ){
        return teamsService.teamInsertA(gamerID,tID);

    }

    @GetMapping("/teamCreate")
    public ResponseEntity teamCreate() {
        return teamsService.teamCreate();
    }

    @GetMapping("/backUpCreate")
    public ResponseEntity backUpCreate() {
        return teamsService.backUpCreate();
    }
}
