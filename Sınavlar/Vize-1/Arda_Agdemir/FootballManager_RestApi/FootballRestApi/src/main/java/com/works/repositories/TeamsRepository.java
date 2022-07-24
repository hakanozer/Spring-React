package com.works.repositories;

import com.works.entities.Footballer;
import com.works.entities.Teams;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeamsRepository extends JpaRepository<Teams, Integer> {
    Optional<Teams> findByFidEquals(Integer fid);
}
