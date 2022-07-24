package com.example.futbolmuskabakasi.services;

import com.example.futbolmuskabakasi.repostories.JoinTeamToFootballer;
import com.example.futbolmuskabakasi.repostories.TeamRepositoyr;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TeamServices {
    final TeamRepositoyr teamRepositoyr;
    final JoinTeamToFootballer joinTeamToFootballer;

    public TeamServices(TeamRepositoyr teamRepositoyr, JoinTeamToFootballer joinTeamToFootballer) {
        this.teamRepositoyr = teamRepositoyr;
        this.joinTeamToFootballer = joinTeamToFootballer;
    }

    public ResponseEntity createTeam() {
        teamRepositoyr.addteamA();
        teamRepositoyr.addteamB();
        teamRepositoyr.addteamBackupA();
        teamRepositoyr.addteamBackupB();
        return new ResponseEntity(true, HttpStatus.OK);
    }
}
