package com.works.repositories;

import com.works.etities.Footballer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FRepository extends JpaRepository<Footballer,Integer> {

}
