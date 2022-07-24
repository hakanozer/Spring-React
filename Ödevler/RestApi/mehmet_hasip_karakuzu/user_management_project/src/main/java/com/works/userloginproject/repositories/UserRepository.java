package com.works.userloginproject.repositories;

import com.works.userloginproject.entities.User;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

  boolean existsByPasswordEquals(String password);



  Optional<User> findByEmailEqualsAndPasswordEquals(String email, String password);

  boolean existsByEmailEqualsIgnoreCase(String email);

}
