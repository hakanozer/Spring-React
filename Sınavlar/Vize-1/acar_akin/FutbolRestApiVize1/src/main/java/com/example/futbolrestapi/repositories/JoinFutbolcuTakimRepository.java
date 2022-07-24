package com.example.futbolrestapi.repositories;

import com.example.futbolrestapi.entities.JoinFutbolcuTakim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JoinFutbolcuTakimRepository extends JpaRepository<JoinFutbolcuTakim, Integer> {
    @Query(value = "SELECT f.fid, f.tid, f.name, f.surname, f.email,f.age, t.teamName FROM footballers as f INNER JOIN teamss as t ON f.tid = t.tid limit ?1,?2",nativeQuery = true)
    List<JoinFutbolcuTakim> teamsCount(int teamMemberA, int teamMemberB);


    @Query(value = "SELECT COUNT(tid) FROM TABLE ( footballers ) where tid ?1",nativeQuery = true)
    int count(int id);



}
