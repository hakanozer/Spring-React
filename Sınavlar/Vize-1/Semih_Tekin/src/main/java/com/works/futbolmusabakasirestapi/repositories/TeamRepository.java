package com.works.futbolmusabakasirestapi.repositories;

import com.works.futbolmusabakasirestapi.entities.Footballer;
import com.works.futbolmusabakasirestapi.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Integer> {

    @Query(value = "SELECT f.name, f.surname FROM Footballer AS f where f.tid=?1 ", nativeQuery = true)
    List<Team> teams(int tid);

}