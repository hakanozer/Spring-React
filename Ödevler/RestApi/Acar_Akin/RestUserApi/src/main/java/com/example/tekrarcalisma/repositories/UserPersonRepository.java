package com.example.tekrarcalisma.repositories;

import com.example.tekrarcalisma.entities.UserPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserPersonRepository extends JpaRepository<UserPerson , Integer> {
    boolean existsByEmailEqualsAllIgnoreCase(String email);

    Optional<UserPerson> findByEmailEqualsAndPasswordEquals(String email, String password);




}
