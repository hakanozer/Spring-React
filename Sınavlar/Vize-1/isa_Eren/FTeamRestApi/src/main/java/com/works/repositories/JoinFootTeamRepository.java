package com.works.repositories;

import com.works.etities.Footballer;
import com.works.etities.JoinFootTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JoinFootTeamRepository extends JpaRepository<JoinFootTeam, Integer> {
    @Query(value = "SELECT * FROM `footballer` f inner join team t on f.team_tid=t.tid;", nativeQuery = true)
    List<JoinFootTeam> findAll();

    @Query(value = "SELECT * FROM footballer f inner join team t on f.team_tid=t.tid order by age", nativeQuery = true)
    List<JoinFootTeam> findAllSortAsc();
}