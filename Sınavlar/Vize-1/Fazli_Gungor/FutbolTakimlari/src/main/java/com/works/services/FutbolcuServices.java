package com.works.services;


import com.works.Util.ERest;
import com.works.entities.Futbolcu;
import com.works.repositories.FutbolcuRepository;
import com.works.repositories.JoinFutbolcuToTakimRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@Validated
public class FutbolcuServices {
    final FutbolcuRepository futbolcuRepository;
    final JoinFutbolcuToTakimRepository joinFutbolcuToTakimRepository;

    public FutbolcuServices(FutbolcuRepository futbolcuRepository, JoinFutbolcuToTakimRepository joinFutbolcuToTakimRepository) {
        this.futbolcuRepository = futbolcuRepository;
        this.joinFutbolcuToTakimRepository = joinFutbolcuToTakimRepository;
    }

    public ResponseEntity save(List<Futbolcu> futbolcus) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        for (Futbolcu futbolcu : futbolcus) {
            futbolcuRepository.save(futbolcu);
        }
        hm.put(ERest.status, true);
        hm.put(ERest.result, futbolcus);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity getAllFutbolcu() {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.status, true);
        hm.put(ERest.result, futbolcuRepository.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity saveFutbolcuToTeam(int fid, int tid) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Optional<Futbolcu> futbolcu = futbolcuRepository.findById(fid);
        if (futbolcu.isPresent()){
            futbolcu.get().setTid(tid);
            futbolcuRepository.saveAndFlush(futbolcu.get());
            hm.put(ERest.status, true);
            hm.put(ERest.message, "Basarılı bır sekılde takıma yerlestırıldı");
            hm.put(ERest.result, futbolcu);
            return new ResponseEntity(hm, HttpStatus.OK);
        }else {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Oyuncu ya da Takım id'si Hatalı!");
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }
    }

}
