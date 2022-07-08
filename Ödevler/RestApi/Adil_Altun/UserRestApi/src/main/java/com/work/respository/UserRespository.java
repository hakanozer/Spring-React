package com.work.respository;

import com.work.entities.UserPerson;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRespository extends JpaRepository <UserPerson,Integer> {

    boolean existsByEmailEqualsAllIgnoreCase(String email);

    Optional<UserPerson> findByEmailEqualsAndPasswordEquals(String email, String password);
}
