package com.works.repositories;

import com.works.entities.UserPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserPersonRepository extends JpaRepository<UserPerson, Integer> {
    Optional<UserPerson> findByEmailEquals(String email);

    Optional<UserPerson> findByEmailEqualsAndPasswordEqualsAllIgnoreCase(String email, String password);

    Optional<UserPerson> findByUidEquals(Integer uid);





}