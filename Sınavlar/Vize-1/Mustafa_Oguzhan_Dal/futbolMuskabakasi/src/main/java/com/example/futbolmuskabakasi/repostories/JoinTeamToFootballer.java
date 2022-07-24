package com.example.futbolmuskabakasi.repostories;

import com.example.futbolmuskabakasi.entities.JoinTeamtoFootballer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JoinTeamToFootballer extends JpaRepository<JoinTeamtoFootballer, Integer> {
    @Query(value = "SELECT f.fid, f.tid, f.name, f.lastname,f.age,f.email, t.team_name FROM footballer as f INNER JOIN team as t ON f.tid = t.tid", nativeQuery = true)
    List<JoinTeamtoFootballer> allFootballer();

    @Query(value = "SELECT COUNT(tid) FROM footballer where tid=?1", nativeQuery = true)
    long count(int id);

    @Query(value = "SELECT f.fid, f.tid, f.name, f.lastname,f.age,f.email, t.team_name FROM footballer as f INNER JOIN team as t ON f.tid = t.tid ORDER BY f.age ASC", nativeQuery = true)
    List<JoinTeamToFootballer> sortbyAge();

    @Query(value = "SELECT f.fid, f.tid, f.name, f.lastname,f.age,f.email, t.team_name FROM footballer as f INNER JOIN team as t ON f.tid = t.tid WHERE f.tid=2", nativeQuery = true)
    List<JoinTeamtoFootballer> allFootballerWithTeamB();
    @Query(value = "SELECT f.fid, f.tid, f.name, f.lastname,f.age,f.email, t.team_name FROM footballer as f INNER JOIN team as t ON f.tid = t.tid WHERE f.tid=1", nativeQuery = true)
    List<JoinTeamtoFootballer> allFootballerWithTeamA();
}
