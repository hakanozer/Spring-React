package com.works.repositories;

import com.works.entities.Futbolcu;
import com.works.entities.Teams;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface TeamsRepository extends JpaRepository<Teams, Integer> {
    @Query(value = "select f from Futbolcu f where f.tid = ?1", nativeQuery = true)
    List<Teams> getTeamsByFutbolcuListAndTeamname(Integer cid);
}