package com.works.repositories;

import com.works.entities.JoinTeamsUser;
import com.works.entities.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JoinTeamsUserRepository extends JpaRepository<JoinTeamsUser, Integer> {


    boolean existsByFidEquals(int fid);







}