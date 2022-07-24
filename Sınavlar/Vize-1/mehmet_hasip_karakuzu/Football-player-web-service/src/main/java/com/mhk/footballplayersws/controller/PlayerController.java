package com.mhk.footballplayersws.controller;


import com.mhk.footballplayersws.entity.Player;
import com.mhk.footballplayersws.service.PlayerService;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("player")
public class PlayerController {


  private final PlayerService playerService;


  public PlayerController(PlayerService playerService) {
    this.playerService = playerService;
  }


  @PostMapping("save/{teamId}")
  ResponseEntity savePlayer(@PathVariable Long teamId, @RequestBody Player player) {
    return playerService.savePlayer(teamId, player);
  }

  @GetMapping("getByTeamId/{id}")
  ResponseEntity getPlayersByTeamId(@PathVariable Long id) {
    return playerService.getPlayersByTeamId(id);
  }

  @GetMapping("topPlayer/{teamId}")
  ResponseEntity getTop11PlayerList(@PathVariable Long teamId, Sort sort) {
    return playerService.getTop11PlayerList(teamId, sort);
  }


  @GetMapping("reserve/{teamId}")
  ResponseEntity getReservePlayers(@PathVariable Long teamId) {
    return playerService.getReservePlayerList(teamId);
  }

}
