package com.works.repositories;

import com.works.entities.FootballPlayer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FootballPlayerRepository extends JpaRepository<com.works.entities.FootballPlayer, Integer> {
    Optional<FootballPlayer> findByEmailEquals(String email);

    Optional<FootballPlayer> findByFidEquals(Integer fid);

}