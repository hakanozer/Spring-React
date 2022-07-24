package com.works.futbolmusabakasirestapi.repositories;

import com.works.futbolmusabakasirestapi.entities.Footballer;
import com.works.futbolmusabakasirestapi.entities.JoinFootballerTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JoinFootballerTeamRepository extends JpaRepository<JoinFootballerTeam, Integer> {




}