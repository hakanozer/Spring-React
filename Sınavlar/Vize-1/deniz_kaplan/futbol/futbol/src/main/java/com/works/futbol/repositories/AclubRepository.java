package com.works.futbol.repositories;

import com.works.futbol.entities.Aclub;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AclubRepository extends JpaRepository<Aclub,Long> {
    boolean existsByPlayer_EmailContainsIgnoreCase(String email);

    List<Aclub> findByOrderByPlayer_AgeAsc(Pageable pageable);

    @Query("select a from Aclub a order by a.player.age DESC")
    List<Aclub> findByOrderByPlayer_AgeDesc(Pageable pageable);






}
