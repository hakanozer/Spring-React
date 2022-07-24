package com.works.springvize1.repository;

import com.works.springvize1.entities.Player;
import com.works.springvize1.entities.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamsRepository extends JpaRepository<Teams, Integer> {


    List<Player> findByIstekContainsIgnoreCaseOrderByAgeAsc(String teams);
}


