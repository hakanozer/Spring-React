package com.works.springvize1.services;

import com.works.springvize1.entities.JoinTeamsPlayer;
import com.works.springvize1.repository.JoinTeamsPlayerRepository;
import com.works.springvize1.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class JoinTeamsPlayerServices {
    final JoinTeamsPlayerRepository jRepo;

    public JoinTeamsPlayerServices(JoinTeamsPlayerRepository jRepo) {
        this.jRepo = jRepo;
    }

    public ResponseEntity teamInsert(JoinTeamsPlayer joinTeamsPlayer) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        jRepo.save(joinTeamsPlayer);
        hm.put(ERest.status, true);
        hm.put(ERest.result, joinTeamsPlayer);
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
