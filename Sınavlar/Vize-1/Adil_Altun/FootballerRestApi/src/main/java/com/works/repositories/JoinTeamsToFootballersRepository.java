package com.works.repositories;

import com.works.entities.JoinTeamsToFootballers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JoinTeamsToFootballersRepository extends JpaRepository<JoinTeamsToFootballers, Integer> {

    @Query(value = "SELECT f.fid, f.tid, f.name, f.surname, f.email,f.age, t.teamName FROM footballers as f INNER JOIN teamss as t ON f.tid = t.tid limit ?1,?2",nativeQuery = true)
    List<JoinTeamsToFootballers> teamCreate (int teamMemberA,int teamMemberB);

    @Query(value = "SELECT COUNT(tid) FROM TABLE ( footballers ) where tid ?1",nativeQuery = true)
    int count(int id);

    @Query(value = "select j from JoinTeamsToFootballers j where upper(j.tid) is not null order by j.age",nativeQuery = true)
    List<JoinTeamsToFootballers> findByTidIsNotNullAllIgnoreCaseOrderByAgeAsc(int teamMemberA);






}