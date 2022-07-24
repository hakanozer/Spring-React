package com.mhk.footballplayersws.repository;

import com.mhk.footballplayersws.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;

public interface TeamRepository extends JpaRepository<Team, Long> {




}
