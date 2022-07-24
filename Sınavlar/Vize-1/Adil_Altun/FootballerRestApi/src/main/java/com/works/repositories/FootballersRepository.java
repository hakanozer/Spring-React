package com.works.repositories;

import com.works.entities.Footballers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface FootballersRepository extends JpaRepository<Footballers, Integer> {

}