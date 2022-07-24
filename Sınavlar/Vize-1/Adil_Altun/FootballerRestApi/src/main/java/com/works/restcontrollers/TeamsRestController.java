package com.works.restcontrollers;

import com.works.entities.Teamss;
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

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Teamss teams){

        return teamsService.save(teams);
    }

    @GetMapping("/list")
    public ResponseEntity list(){
        return teamsService.list();
    }
}
