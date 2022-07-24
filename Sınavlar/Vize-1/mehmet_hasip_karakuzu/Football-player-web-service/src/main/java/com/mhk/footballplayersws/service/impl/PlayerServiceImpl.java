package com.mhk.footballplayersws.service.impl;

import com.mhk.footballplayersws.entity.Player;
import com.mhk.footballplayersws.entity.Team;
import com.mhk.footballplayersws.repository.PlayerRepository;
import com.mhk.footballplayersws.repository.TeamRepository;
import com.mhk.footballplayersws.service.PlayerService;
import com.mhk.footballplayersws.util.JsonFormat;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

  private final PlayerRepository playerRepository;
  private final TeamRepository teamRepository;


  public PlayerServiceImpl(PlayerRepository playerRepository, TeamRepository teamRepository) {
    this.playerRepository = playerRepository;
    this.teamRepository = teamRepository;
  }

  @Override
  public ResponseEntity savePlayer(Long teamId, Player player) {
    Map<JsonFormat, Object> hm = new LinkedHashMap<>();
    Optional<Team> optionalTeam = teamRepository.findById(teamId);
    if (optionalTeam.isPresent()) {
      Team team = optionalTeam.get();
      if (team.getTeamId() == player.getTeam().getTeamId()) {
        hm.put(JsonFormat.status, false);
        hm.put(JsonFormat.message, "player already has another team");
      } else {
        hm.put(JsonFormat.status, true);
        hm.put(JsonFormat.message, "player saved successfully");
        hm.put(JsonFormat.player, playerRepository.save(player));
      }

    }
    return new ResponseEntity(hm, HttpStatus.OK);
  }

  @Override
  public ResponseEntity getPlayersByTeamId(Long teamId) {
    Map<JsonFormat, Object> hm = new LinkedHashMap<>();
    hm.put(JsonFormat.status, true);
    hm.put(JsonFormat.message, "get player List by team successfully");
    hm.put(JsonFormat.teamPlayers, playerRepository.findByTeam_TeamIdEquals(teamId));
    return new ResponseEntity(hm, HttpStatus.OK);
  }

  @Override
  public ResponseEntity getTop11PlayerList(Long teamId, Sort sort) {
    Map<JsonFormat, Object> hm = new LinkedHashMap<>();
    hm.put(JsonFormat.status, true);
    hm.put(JsonFormat.message, "get top 11 player List by team successfully");
    hm.put(JsonFormat.top11PlayerList, playerRepository.findTop11ByTeam_TeamIdOrderByAgeAsc(teamId, sort));
    return new ResponseEntity(hm, HttpStatus.OK);
  }

  @Override
  public ResponseEntity getReservePlayerList(Long teamId) {
    Map<JsonFormat, Object> hm = new LinkedHashMap<>();
    List<Player> page = playerRepository.findByTeam_TeamId(teamId,
        PageRequest.of(1, 11, Sort.by(Direction.ASC, "age")));
    hm.put(JsonFormat.status, true);
    hm.put(JsonFormat.message, "get reserve player List by team successfully");
    hm.put(JsonFormat.reservePlayerList, page);
    return new ResponseEntity(hm, HttpStatus.OK);
  }
}
