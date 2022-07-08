package com.works.repositories;

import com.works.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByEmailEqualsAllIgnoreCase(String email);

    Optional<User> findByEmailEqualsAndPasswordEquals(String email, String password);








}
