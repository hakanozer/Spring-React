package com.works.services;

import com.works.entities.User;
import com.works.repositories.UserRepository;
import com.works.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeamsService {
    final UserRepository uRepo;

    public TeamsService(UserRepository uRepo) {
        this.uRepo = uRepo;
    }

    public ResponseEntity teamCreate () {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.status, true);
        List<User> teamA = uRepo.userList(1);
        List<User> teamB = uRepo.userList(2);
        hm.put(ERest.teamA,teamA);
        hm.put(ERest.teamB,teamB);
        return new ResponseEntity(hm, HttpStatus.OK);

    }

    public ResponseEntity backUpCreate  () {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.status, true);
        List<User> BackUpteamA = uRepo.backUpUser(1);
        List<User> BackUpteamB = uRepo.backUpUser(2);
        hm.put(ERest.BackUpTeamA,BackUpteamA);
        hm.put(ERest.BackUpTeamB,BackUpteamB);
        return new ResponseEntity(hm, HttpStatus.OK);

    }
}
