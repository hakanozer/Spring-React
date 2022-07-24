package com.works.restcontrollers;

import com.works.entities.Teams;
import com.works.services.TeamsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teams")
public class TeamsController {
    final TeamsService tService;

    public TeamsController(TeamsService tService) {
        this.tService = tService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Teams teams){
        return tService.save(teams);
    }
    @GetMapping("/list")
    public ResponseEntity list(){
        return tService.list();
    }
}
