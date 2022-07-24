package com.works.repositories;

import com.works.entities.JoinPlayerTeams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JoinPlayerTeamsRepository extends JpaRepository<JoinPlayerTeams, Integer> {

    @Query(value = "SELECT p.fid, p.tid, p.name, p.surname,p.email, p.password, p.age, t.teamName FROM player as p " +
            "INNER JOIN teams as t ON p.tid = t.tid", nativeQuery = true)
    List<JoinPlayerTeams> allPlayers();

    @Query(value = "", nativeQuery = true)



}