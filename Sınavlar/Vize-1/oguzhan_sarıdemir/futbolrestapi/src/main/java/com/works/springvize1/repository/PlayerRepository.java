package com.works.springvize1.repository;

import com.works.springvize1.entities.JoinTeamsPlayer;
import com.works.springvize1.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Integer> {
    @Query(value = "SELECT * FROM player Where Pid=?1",nativeQuery = true)
    Object player(int id);
    @Query(value = "SELECT p.Pid, p.tid, p.name, p.username, p.age as  FROM Player as p INNER JOIN Teams as c ON p.tid = t.tid WHERE p.Pid LIKE ?1", nativeQuery = true)
    List<JoinTeamsPlayer> search(String q);
}