package com.works.futbolmusabakasirestapi.repositories;

import com.works.futbolmusabakasirestapi.entities.Footballer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface FootballerRepository extends JpaRepository<Footballer, Integer> {

    List<Footballer> getFootballerByFidAndTid(int fid, int tid);

}