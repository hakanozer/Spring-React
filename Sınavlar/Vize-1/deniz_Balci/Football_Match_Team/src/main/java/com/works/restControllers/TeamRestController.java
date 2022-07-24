package com.works.restControllers;

import com.works.entities.Team;
import com.works.services.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class TeamRestController {

    final TeamService tService;
    public TeamRestController(TeamService tService) {
        this.tService = tService;
    }

    @PostMapping("/teamInsert/{team}")
    public ResponseEntity save (@PathVariable String team, @RequestParam Integer fid){
        return tService.save(team, fid);
    }
}
