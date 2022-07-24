package com.mhk.footballplayersws.service;

import com.mhk.footballplayersws.entity.Player;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;

public interface PlayerService {

  ResponseEntity savePlayer(Long teamId, Player player);

  ResponseEntity getPlayersByTeamId(Long teamId);

  ResponseEntity getTop11PlayerList(Long teamId, Sort sort);

  ResponseEntity getReservePlayerList(Long teamId);

}
