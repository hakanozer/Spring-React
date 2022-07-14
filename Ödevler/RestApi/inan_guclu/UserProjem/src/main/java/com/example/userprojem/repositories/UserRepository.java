package com.example.userprojem.repositories;

import com.example.userprojem.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    boolean existsByEmailEqualsIgnoreCase(String email);

    Optional<User> findByEmailEqualsAndPasswordEqualsAllIgnoreCase(String email, String password);

    Optional<User> findByUidEquals(Integer uid);



}
