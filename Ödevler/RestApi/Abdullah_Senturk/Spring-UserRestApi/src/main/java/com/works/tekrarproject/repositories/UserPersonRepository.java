package com.works.tekrarproject.repositories;

import com.works.tekrarproject.entities.UserPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserPersonRepository extends JpaRepository<UserPerson, Integer> {

    boolean existsByEmailEqualsIgnoreCase(String email);
    // email'in olup olmadığının kontrolünü yapar
    // Bunu yazdığımızda try-catch denetimine gerek kalmaz

}
