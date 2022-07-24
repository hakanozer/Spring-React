package com.example.futbolmuskabakasi.services;

import com.example.futbolmuskabakasi.repostories.JoinTeamToFootballer;
import com.example.futbolmuskabakasi.repostories.TeamRepositoyr;
import org.springframework.stereotype.Service;

@Service
public class TeamServices {
    final TeamRepositoyr teamRepositoyr;
    final JoinTeamToFootballer joinTeamToFootballer;

    public TeamServices(TeamRepositoyr teamRepositoyr, JoinTeamToFootballer joinTeamToFootballer) {
        this.teamRepositoyr = teamRepositoyr;
        this.joinTeamToFootballer = joinTeamToFootballer;
    }

}
