package com.works.repositories;

import com.works.entities.Player;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    boolean existsByPidEquals(Integer pid);

    @Query(value = "SELECT p.pid, p.name, p.surname, p.email, p.age, p.password FROM teams_player as t INNER JOIN player as p ON p.pid = t.pid WHERE t.tid = ?1 ORDER BY p.age ASC LIMIT ?2,?3", nativeQuery = true)
    List<Player> listPlayer(int teamId, int page, int count );


}