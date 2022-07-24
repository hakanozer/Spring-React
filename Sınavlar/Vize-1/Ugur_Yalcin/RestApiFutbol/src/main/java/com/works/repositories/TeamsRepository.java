package com.works.repositories;

import com.works.entities.Player;
import com.works.entities.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TeamsRepository extends JpaRepository<Teams, Integer> {
    Optional<Teams> findById(Integer tid);

}
