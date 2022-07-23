package com.works.futbol.repositories;

import com.works.futbol.entities.Bclub;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BclubRepository extends JpaRepository<Bclub,Long> {
    Bclub findByPlayer_EmailContains(String email);

    boolean existsByPlayer_EmailContainsIgnoreCase(String email);





}
