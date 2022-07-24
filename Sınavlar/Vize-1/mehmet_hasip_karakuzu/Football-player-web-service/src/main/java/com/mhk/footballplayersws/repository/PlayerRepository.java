package com.mhk.footballplayersws.repository;


import com.mhk.footballplayersws.entity.Player;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {

  List<Player> findByTeam_TeamIdEquals(Long teamId);

  List<Player> findTop11ByTeam_TeamIdOrderByAgeAsc(Long teamId, Sort sort);

  List<Player> findByTeam_TeamId(Long teamId, Pageable pageable);


}
