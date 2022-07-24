package com.works.services;

import com.works.Util.ERest;
import com.works.entities.Futbolcu;
import com.works.repositories.JoinFutbolcuToTakimRepository;
import com.works.repositories.TeamsRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
@Validated
public class TeamsService {

    final TeamsRepository teamsRepository;
    final JoinFutbolcuToTakimRepository joinFutbolcuToTakimRepository;

    public TeamsService(TeamsRepository teamsRepository, JoinFutbolcuToTakimRepository joinFutbolcuToTakimRepository) {
        this.teamsRepository = teamsRepository;
        this.joinFutbolcuToTakimRepository = joinFutbolcuToTakimRepository;
    }

    public ResponseEntity getTeamPlayer(int id) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.status, true);
        hm.put(ERest.result, teamsRepository.getTeamsByFutbolcuListAndTeamname(id));
        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
