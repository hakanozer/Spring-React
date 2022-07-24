package com.example.futbolmuskabakasi.controllers;

import com.example.futbolmuskabakasi.services.TeamServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/team")
public class TeamController {
    final TeamServices teamServices;

    public TeamController(TeamServices teamServices) {
        this.teamServices = teamServices;
    }

    @GetMapping
    public ResponseEntity createTeam() {
        return teamServices.createTeam();
    }
}
