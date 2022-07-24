package com.works.repositories;

import com.works.etities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TRepository extends JpaRepository<Team,Integer> {

}
