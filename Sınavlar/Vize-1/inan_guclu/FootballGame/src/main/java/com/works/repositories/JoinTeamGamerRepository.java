package com.works.repositories;

import com.works.entities.JoinTeamGamer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JoinTeamGamerRepository extends JpaRepository<JoinTeamGamer, Integer> {
    @Query(value = "SELECT g.gamerid ,g.age ,g.name , g.surname, g.email,g.teamid FROM gamer AS g INNER JOIN teams AS t ON g.gamerid=t.gamerid",nativeQuery = true)
    List<JoinTeamGamer> allGamer();



}