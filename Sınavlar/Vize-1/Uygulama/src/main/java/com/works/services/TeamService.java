package com.works.services;

import com.works.entities.Team;
import com.works.repositories.FootballerRepository;
import com.works.repositories.TeamRepository;
import com.works.utils.REnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class TeamService {

    final TeamRepository tRepo;
    final FootballerRepository fRepo;
    public TeamService(TeamRepository tRepo, FootballerRepository fRepo) {
        this.tRepo = tRepo;
        this.fRepo = fRepo;
    }


    public ResponseEntity save(Team team) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        try {
            boolean status = fRepo.existsByFidEquals(team.getFid());
            if (!status) {
                hm.put( REnum.status, false );
                hm.put( REnum.message, "Böyle bir futbolcu yok" );
                hm.put( REnum.result, team );
            }else {
                tRepo.save(team);
                hm.put( REnum.status, true );
                hm.put( REnum.message, "Kayıt işlemi başarılı" );
                hm.put( REnum.result, team );
            }
        }catch (Exception ex) {
            hm.put( REnum.status, false );
            hm.put( REnum.message, "Bu futbolcu daha önce bir takıma atanmış" );
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }





}
