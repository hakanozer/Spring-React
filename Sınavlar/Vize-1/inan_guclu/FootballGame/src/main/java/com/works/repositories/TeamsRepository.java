package com.works.repositories;

import com.works.entities.Teams;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamsRepository extends JpaRepository<Teams, Integer> {
}