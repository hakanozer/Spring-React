package com.works.repositories;

import com.works.entities.Footballer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FootballerRepository extends JpaRepository<Footballer, Integer> {


}
