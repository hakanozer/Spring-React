package com.works.repositories;


import com.works.entities.JoinFutbolcuToTakim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface JoinFutbolcuToTakimRepository extends JpaRepository<JoinFutbolcuToTakim, Integer> {


}
