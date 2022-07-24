package com.works.repositories;

import com.works.entities.Futbolcu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FutbolcuRepository extends JpaRepository<Futbolcu, Integer> {

}
