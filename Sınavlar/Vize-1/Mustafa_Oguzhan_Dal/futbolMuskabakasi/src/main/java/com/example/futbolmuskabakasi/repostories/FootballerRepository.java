package com.example.futbolmuskabakasi.repostories;


import com.example.futbolmuskabakasi.entities.Footballer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FootballerRepository extends JpaRepository<Footballer, Integer> {
    @Query(value = "SELECT * FROM footballer WHERE footballer.tid=0 ORDER BY footballer.age ASC", nativeQuery = true)
    List<Footballer> findByOrderByAgeAsc();

    @Query(value = "SELECT * FROM footballer WHERE footballer.tid=1 OR footballer.tid=2;", nativeQuery = true)
    List<Footballer> playersWithTeam();

    @Query(value = "SELECT * FROM footballer WHERE footballer.tid=1;", nativeQuery = true)
    List<Footballer> playersWithTeamA();

    @Query(value = "SELECT * FROM footballer WHERE footballer.tid=2;", nativeQuery = true)
    List<Footballer> playersWithTeamB();


}
