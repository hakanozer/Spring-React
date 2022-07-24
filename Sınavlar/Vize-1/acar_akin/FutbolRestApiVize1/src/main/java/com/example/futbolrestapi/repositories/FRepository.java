package com.example.futbolrestapi.repositories;

import com.example.futbolrestapi.entities.Futbolcu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FRepository extends JpaRepository<Futbolcu,Integer> {



}
