package com.mhk.footballplayersws.controller;


import com.mhk.footballplayersws.entity.Team;
import com.mhk.footballplayersws.service.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("team")
public class TeamController {

  private final TeamService teamService;


  public TeamController(TeamService teamService) {
    this.teamService = teamService;
  }

  @PostMapping("create")
  ResponseEntity createTeam(@RequestBody Team team) {
    return teamService.createTeam(team);
  }


  @GetMapping("getTeams")
  ResponseEntity getTeams() {
    return teamService.getTeams();
  }
}
