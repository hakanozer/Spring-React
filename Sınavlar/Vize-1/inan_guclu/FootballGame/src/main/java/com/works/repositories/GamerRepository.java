package com.works.repositories;

import com.works.entities.Gamer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GamerRepository extends JpaRepository<Gamer, Integer> {
    boolean existsByEmailContainsIgnoreCaseAllIgnoreCase(String email);

    Gamer findByEmailEqualsIgnoreCase(String email);



}