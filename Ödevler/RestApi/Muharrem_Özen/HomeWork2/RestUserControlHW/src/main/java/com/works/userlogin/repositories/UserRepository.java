package com.works.userlogin.repositories;

import com.works.userlogin.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <User,Integer> {
  Optional <User> findByEmailEqualsAndPasswordEquals(String email, String password);

       boolean existsByEmailEquals(String email);












}
