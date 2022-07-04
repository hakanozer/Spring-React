package com.works.repositories;

import com.works.entities.UserPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPersonRepository extends JpaRepository<UserPerson, Integer> {

    boolean existsByEmailEqualsAllIgnoreCase(String email);


}