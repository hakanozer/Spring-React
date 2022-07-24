package com.works.repositories;

import com.works.entities.Player;
import com.works.entities.TeamsPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamsPlayerRepository extends JpaRepository<TeamsPlayer, Integer> {

    boolean existsByPidEquals(Integer pid);




}