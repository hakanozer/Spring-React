package com.works.futbolmusabakasirestapi.restcontrollers;

import com.works.futbolmusabakasirestapi.entities.Team;
import com.works.futbolmusabakasirestapi.services.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team")
public class TeamRestController {


    final TeamService teamService;
    public TeamRestController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Team team){
        return teamService.save(team);
    }

    @GetMapping("/list")
    public ResponseEntity list(){
        return teamService.list();
    }

    @GetMapping("/teams")
    public ResponseEntity teams(@RequestParam int tid){
        return teamService.teams(tid);
    }

}
