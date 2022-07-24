package com.works.repositories;

import com.works.entities.FootballPlayer;
import com.works.entities.JoinTeamPlayer;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface JoinTeamPlayerRepository extends JpaRepository<JoinTeamPlayer, Integer> {
    @Query(value = "SELECT * FROM team as t INNER JOIN football_player as f on f.fid = t.fid WHERE t.team LIKE ?1 ORDER BY f.age", nativeQuery = true)
    List<JoinTeamPlayer> listTeam(String q);
}