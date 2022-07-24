package com.mhk.footballplayersws.service;

import com.mhk.footballplayersws.entity.Team;
import org.springframework.http.ResponseEntity;

public interface TeamService {
  ResponseEntity createTeam(Team team);

  ResponseEntity getTeams();
}
