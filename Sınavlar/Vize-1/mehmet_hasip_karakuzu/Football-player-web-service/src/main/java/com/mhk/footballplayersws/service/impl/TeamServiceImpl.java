package com.mhk.footballplayersws.service.impl;

import com.mhk.footballplayersws.entity.Team;
import com.mhk.footballplayersws.repository.TeamRepository;
import com.mhk.footballplayersws.service.TeamService;
import com.mhk.footballplayersws.util.JsonFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TeamServiceImpl implements TeamService {

  private final TeamRepository teamRepository;

  public TeamServiceImpl(TeamRepository teamRepository) {
    this.teamRepository = teamRepository;
  }

  @Override
  public ResponseEntity createTeam(Team team) {
    Map<JsonFormat, Object> hm = new LinkedHashMap<>();

    hm.put(JsonFormat.status, true);
    hm.put(JsonFormat.message, "team created successfully");
    hm.put(JsonFormat.team, teamRepository.save(team));

    return new ResponseEntity(hm, HttpStatus.OK);
  }

  @Override
  public ResponseEntity getTeams() {
    Map<JsonFormat, Object> hm = new LinkedHashMap<>();

    hm.put(JsonFormat.status, true);
    hm.put(JsonFormat.message, "all teams found successfully");
    hm.put(JsonFormat.teams, teamRepository.findAll());

    return new ResponseEntity(hm, HttpStatus.OK);
  }
}
