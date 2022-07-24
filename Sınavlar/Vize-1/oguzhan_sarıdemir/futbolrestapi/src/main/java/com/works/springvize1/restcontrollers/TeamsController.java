package com.works.springvize1.restcontrollers;

import com.works.springvize1.entities.Teams;
import com.works.springvize1.services.TeamsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamsController {
    final TeamsService tService;

    public TeamsController(TeamsService tService) {
        this.tService = tService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Teams teams) {
        return tService.getall(teams);
    }
}