package com.works.services;

import com.works.entities.Team;
import com.works.repositories.FootballPlayerRepository;
import com.works.repositories.TeamRepository;
import com.works.utils.Erest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class TeamService {

    final TeamRepository tRepo;
    final FootballPlayerRepository fRepo;

    public TeamService(TeamRepository tRepo, FootballPlayerRepository fRepo) {
        this.tRepo = tRepo;
        this.fRepo = fRepo;
    }

    public ResponseEntity save (String team, Integer fid) {
        Map<Erest, Object > hm = new LinkedHashMap<>();
        if (team.equals("A") || team.equals("B")){
            if (!fRepo.findByFidEquals(fid).isPresent()){
            hm.put(Erest.status,"False");
            hm.put(Erest.message,fid+" id not found,please check your id");
            }else if (tRepo.findByFidEquals(fid).isPresent()){
            hm.put(Erest.status,"False");
            String pTeam = tRepo.findByFidEquals(fid).get().getTeam();
            hm.put(Erest.message, "fid :" +fid+ ", Player has previously joined "+pTeam+" team.");
            }else{
            hm.put(Erest.status,"True");
            Team team1 = new Team();
            team1.setTeam(team);
            team1.setFid(fid);
            hm.put(Erest.result,tRepo.save(team1));
            }

        }else{
            hm.put(Erest.status,"False");
            hm.put(Erest.message,"Team name must be A or B");

        }
            return new ResponseEntity(hm, HttpStatus.OK);
    }
}
