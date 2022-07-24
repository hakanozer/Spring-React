package com.works.controllers;

import com.works.business.TeamsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teams")
public class TeamsController {

    final TeamsService teamsService;

    public TeamsController(TeamsService teamsService) {
        this.teamsService = teamsService;
    }

    @PostMapping("/insert/{teamName}")
    public ResponseEntity teamsInsert(@PathVariable String teamName, @RequestParam Integer fid){
        return teamsService.teamsInsert(teamName, fid);
    }
}
