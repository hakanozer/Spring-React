package com.works.repositories;

import com.works.entities.JoinFT;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JoinFTRepository extends JpaRepository<JoinFT, Integer> {

    @Query(value = "SELECT f.fid, f.name, f.surname, f.age, t.tid, t.team_name FROM footballer as f inner join teams as t on f.fid = t.fid where t.team_name LIKE ?1 ORDER BY f.age;", nativeQuery = true)
    List<JoinFT> getAllData(String q);

}
