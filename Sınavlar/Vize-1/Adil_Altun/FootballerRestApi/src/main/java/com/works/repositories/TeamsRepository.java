package com.works.repositories;

import com.works.entities.Teamss;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamsRepository extends JpaRepository<Teamss, String> {
}