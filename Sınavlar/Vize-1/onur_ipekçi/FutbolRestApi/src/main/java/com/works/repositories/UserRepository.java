package com.works.repositories;

import com.works.entities.JoinTeamsUser;
import com.works.entities.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT u.fid, u.name, u.surname, u.email, u.age, u.password FROM join_teams_user as j INNER JOIN user as u ON u.fid = j.fid WHERE j.tid = ?1 ORDER BY u.age ASC LIMIT 11", nativeQuery = true)
    List<User> userList(int tid );

    @Query(value = "SELECT u.fid, u.name, u.surname, u.email, u.age, u.password FROM join_teams_user as j INNER JOIN user as u ON u.fid = j.fid WHERE j.tid = ?1 ORDER BY u.age ASC LIMIT 11,5", nativeQuery = true)
    List<User>backUpUser(int tid );

    Optional<User> findByFidEquals(int fid);



}