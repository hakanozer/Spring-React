package com.works.repositories;

import com.works.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    List<User> findByNameContainsIgnoreCaseOrSurnameContainsIgnoreCase(String name, String surname);
    Optional<User> findByEmailEqualsAndPasswordEquals( String email, String password );

    // List
    // Select * from user -> bütün tablo bilgileri gelir. ls.size() -> count

    // count
    // select count from user -> sadece satır sayısı -> count

    int countAllBy();
    

}
