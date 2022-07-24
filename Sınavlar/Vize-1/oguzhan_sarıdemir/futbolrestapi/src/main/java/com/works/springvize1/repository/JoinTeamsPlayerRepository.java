package com.works.springvize1.repository;

import com.works.springvize1.entities.JoinTeamsPlayer;
import com.works.springvize1.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JoinTeamsPlayerRepository extends JpaRepository<JoinTeamsPlayer, Integer> {

}