package com.works.futbolmusabakasirestapi.services;

import com.works.futbolmusabakasirestapi.entities.Footballer;
import com.works.futbolmusabakasirestapi.entities.JoinFootballerTeam;
import com.works.futbolmusabakasirestapi.repositories.FootballerRepository;
import com.works.futbolmusabakasirestapi.repositories.JoinFootballerTeamRepository;
import com.works.futbolmusabakasirestapi.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class FootballerService {

    final FootballerRepository footballerRepository;
    final JoinFootballerTeamRepository joinFootballerTeamRepository;
    public FootballerService(FootballerRepository footballerRepository, JoinFootballerTeamRepository joinFootballerTeamRepository) {
        this.footballerRepository = footballerRepository;
        this.joinFootballerTeamRepository = joinFootballerTeamRepository;
    }

    public ResponseEntity save(Footballer footballer){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        if (footballer.getAge()>18){
            footballerRepository.save(footballer);
            hm.put(ERest.status, true);
            hm.put(ERest.result, footballer);
        }else {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "18 yasindan kucukler kayit olamaz.");
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list(){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.status, true);
        hm.put(ERest.result, footballerRepository.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity search(String fid, String tid){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        int iFid = Integer.parseInt(fid);
        int iTid = Integer.parseInt(tid);
        List<Footballer> footballerList = footballerRepository.getFootballerByFidAndTid(iFid, iTid);

        if (iTid==1){
            hm.put(ERest.status, true);
            hm.put(ERest.message, "A takimina katıldı.");
            hm.put(ERest.result, footballerList);
        } else if (iTid==2) {
            hm.put(ERest.status, true);
            hm.put(ERest.message, "B takimina katıldı.");
            hm.put(ERest.result, footballerList);
        }else {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Yanliş tid girdiniz.");
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
