package com.works.futbol.repositories;

import com.works.futbol.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    Optional<Player> findByEmailIs(String email);

    List<Player> findByOrderByAgeAsc();

    List<Player> findByIstekContainsIgnoreCaseOrderByAgeAsc(String istek);






}
