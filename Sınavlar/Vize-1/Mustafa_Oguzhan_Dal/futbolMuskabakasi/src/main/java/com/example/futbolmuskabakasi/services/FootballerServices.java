package com.example.futbolmuskabakasi.services;

import com.example.futbolmuskabakasi.Utils.ERest;
import com.example.futbolmuskabakasi.Utils.Util;
import com.example.futbolmuskabakasi.entities.Footballer;
import com.example.futbolmuskabakasi.repostories.FootballerRepository;
import com.example.futbolmuskabakasi.repostories.JoinTeamToFootballer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class FootballerServices {
    final FootballerRepository footballerRepository;
    final JoinTeamToFootballer joinTeamToFootballer;

    public FootballerServices(FootballerRepository footballerRepository, JoinTeamToFootballer joinTeamToFootballer) {
        this.footballerRepository = footballerRepository;
        this.joinTeamToFootballer = joinTeamToFootballer;
    }

    public ResponseEntity register(List<Footballer> footballer) {
        Map<ERest, Object> hm = new HashMap<>();
        try {
            List<Object> ls = new ArrayList<>();
            for (Footballer item : footballer) {
                item.setPassword(Util.md5(item.getPassword()));
                footballerRepository.saveAll(footballer);
                ls.add(item);
            }
            hm.put(ERest.status, true);
            hm.put(ERest.result, ls);
        } catch (Exception e) {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Register Error");
            return new ResponseEntity(hm, HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity addToTeam(int fid, int tid) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Optional<Footballer> footballer = footballerRepository.findById(fid);
        if (footballer.isPresent()) {
            Footballer dbfootballer = footballer.get();
            dbfootballer.setTid(tid);
            footballerRepository.saveAndFlush(dbfootballer);
            hm.put(ERest.status, true);
            hm.put(ERest.result, footballer);
        } else {
            hm.put(ERest.status, false);
            hm.put(ERest.result, "player not found");
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity getAll() {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.status, true);
        hm.put(ERest.result, footballerRepository.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity teamCreate() {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        teamIdSetNull();
        List<Footballer> footballerList = footballerRepository.findByOrderByAgeAsc();
        try {
            for (int i = 0; i < 5; i++) {//Takımlar kaç kişi olacağının seçimi testi kolay olsun diye sayı düşük tutulmuştus
                Footballer footballer = footballerList.get(i);
                footballer.setTid(1);
                footballerRepository.save(footballer);
            }
            List<Footballer> footballerList2 = footballerRepository.findByOrderByAgeAsc();
            for (int i = 0; i < 5; i++) {//Takımlar kaç kişi olacağının seçimi testi kolay olsun diye sayı düşük tutulmuştus
                Footballer footballer = footballerList2.get(i);
                footballer.setTid(2);
                footballerRepository.save(footballer);
            }
            hm.put(ERest.teamA, joinTeamToFootballer.allFootballerWithTeamA());
            hm.put(ERest.teamB, joinTeamToFootballer.allFootballerWithTeamB());
        } catch (Exception e) {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Yeterli sayıya ulaşılamadığı için takımlar oluşturulamadı");
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    void teamIdSetNull() {
        List<Footballer> footballerList = footballerRepository.findAll();
        for (Footballer footballer : footballerList) {
            Footballer footballer1 = footballer;
            footballer1.setTid(0);
            footballerRepository.save(footballer1);
        }
    }
}
