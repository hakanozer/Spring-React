package com.works.restcontrollers;

import com.works.entities.Team;
import com.works.services.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class TeamRestController {
    final TeamService teamService;

    public TeamRestController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Team team) {
        return teamService.save(team);

    }
}


