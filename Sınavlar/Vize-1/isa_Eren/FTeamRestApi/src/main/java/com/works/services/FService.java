package com.works.services;

import com.works.etities.Footballer;
import com.works.etities.JoinFootTeam;
import com.works.etities.Team;
import com.works.repositories.FRepository;
import com.works.repositories.JoinFootTeamRepository;
import com.works.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FService {
    final FRepository fRepository;
    final JoinFootTeamRepository joinFootTeamRepository;

    public FService(FRepository fRepository, JoinFootTeamRepository joinFootTeamRepository) {
        this.fRepository = fRepository;
        this.joinFootTeamRepository = joinFootTeamRepository;
    }



    public ResponseEntity footballerRegister(Footballer footballer) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Footballer footballer1 = fRepository.save(footballer);
        hm.put(ERest.status, true);
        hm.put(ERest.fid, footballer.getFid());
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    List<Footballer> ls=new ArrayList<>();
    public ResponseEntity teamInsertA(Integer id) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Optional<Footballer> optionalFootballer = fRepository.findById(id);
        if (optionalFootballer.get().getTeam() == null) {
            optionalFootballer.get().setTeam(new Team(3, "A", ls));
            List<JoinFootTeam> ls1=joinFootTeamRepository.findAll();
            hm.put(ERest.result, ls1);
            hm.put(ERest.status, true);
        } else {
            hm.put(ERest.message, "Bu futbolcunun zaten bir takımla sözleşmesi devam ediyor ");
            hm.put(ERest.status, false);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity teamInsertB(Integer id) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Optional<Footballer> optionalFootballer = fRepository.findById(id);
        if (optionalFootballer.get().getTeam() == null) {
            optionalFootballer.get().setTeam(new Team(4, "B", ls));

            hm.put(ERest.result, ls);
            hm.put(ERest.status, true);
        } else {
            hm.put(ERest.message, "Bu futbolcunun zaten bir takımla sözleşmesi devam ediyor ");
            hm.put(ERest.status, false);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}