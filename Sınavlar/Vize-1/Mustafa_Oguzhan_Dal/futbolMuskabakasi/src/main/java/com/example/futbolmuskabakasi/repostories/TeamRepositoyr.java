package com.example.futbolmuskabakasi.repostories;


import com.example.futbolmuskabakasi.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TeamRepositoyr extends JpaRepository<Team, Integer> {

    @Query(value = "INSERT INTO team (tid, team_name) VALUES (1, 'Team A')", nativeQuery = true)
    void addteamA();
    @Query(value = "INSERT INTO team (tid, team_name) VALUES (2, 'Team B')", nativeQuery = true)
    void addteamB();
    @Query(value = "INSERT INTO team (tid, team_name) VALUES (3, 'Team backup A')", nativeQuery = true)
    void addteamBackupA();
    @Query(value = "INSERT INTO team (tid, team_name) VALUES (4, 'Team backup B')", nativeQuery = true)
    void addteamBackupB();

}
