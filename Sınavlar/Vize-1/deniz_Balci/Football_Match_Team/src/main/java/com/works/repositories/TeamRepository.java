package com.works.repositories;

import com.works.entities.Team;
import com.works.services.TeamService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    Optional<Team> findByFidEquals(Integer fid);

}