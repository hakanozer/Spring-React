package com.works.business;

import com.works.entities.Teams;
import com.works.repositories.FootballerRepository;
import com.works.repositories.TeamsRepository;
import com.works.utilities.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class TeamsService {
    final TeamsRepository teamsRepository;
    final FootballerRepository footballerRepository;

    public TeamsService(TeamsRepository teamsRepository, FootballerRepository footballerRepository) {
        this.teamsRepository = teamsRepository;
        this.footballerRepository = footballerRepository;
    }

    public ResponseEntity teamsInsert(String teamName, Integer fid){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Optional<Teams> oFootballer = teamsRepository.findByFidEquals(fid);
        if (oFootballer.isPresent()){
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Futbolcu zaten bu takımda.");
        }
        else if (!footballerRepository.findByFidEquals(fid).isPresent()){
            hm.put(ERest.status, false);
            hm.put(ERest.message, "böyle bir oyuncu yok");
        }
        else {
            hm.put(ERest.result, true);
            Teams teams = new Teams();
            teams.setTeamName(teamName);
            teams.setFid(fid);
            hm.put(ERest.result, teamsRepository.save(teams));
            hm.put(ERest.message, "Tebrikler, " +
                    teamsRepository.findByFidEquals(fid).get().getTeamName()
                    + " " + "takımına katıldınız.");
        }

        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
