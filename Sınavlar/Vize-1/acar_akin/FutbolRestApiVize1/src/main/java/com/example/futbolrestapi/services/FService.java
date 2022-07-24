package com.example.futbolrestapi.services;

import com.example.futbolrestapi.entities.Futbolcu;
import com.example.futbolrestapi.repositories.FRepository;
import com.example.futbolrestapi.repositories.JoinFutbolcuTakimRepository;
import com.example.futbolrestapi.utils.ENumRest;
import com.example.futbolrestapi.utils.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class FService {
    final JoinFutbolcuTakimRepository joinFutbolcuTakimRepository;
    final FRepository fRepo;
    public FService(JoinFutbolcuTakimRepository joinFutbolcuTakimRepository, FRepository fRepo) {
        this.joinFutbolcuTakimRepository = joinFutbolcuTakimRepository;
        this.fRepo = fRepo;
    }

    public ResponseEntity footballerRegister( Futbolcu futbolcu) {
        Map<ENumRest, Object> hm = new LinkedHashMap<>();
        futbolcu.setPassword(Util.md5(futbolcu.getPassword()));
        if (futbolcu.getTid() > 0 && futbolcu.getTid() <= 2) {
            hm.put(ENumRest.status, true);
            hm.put(ENumRest.result, fRepo.save(futbolcu));
        } else {
            hm.put(ENumRest.status, false);
            hm.put(ENumRest.message, "Tid 1 ya da 2 olmalıdır"); //(1- A takımı)------(2- B Takımı)
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity teamInsert( int fid, int tid){
        Map<ENumRest, Object> hm = new LinkedHashMap<>();
        Futbolcu futbolcu = new Futbolcu();
        Optional<Futbolcu> optinalFutbolcu = fRepo.findById(fid);
        if ( optinalFutbolcu.isPresent()){
            if ( joinFutbolcuTakimRepository.count(tid) <=2){
                Futbolcu dbfutbolcu = optinalFutbolcu.get();
                dbfutbolcu.setTid(tid);
                fRepo.saveAndFlush(dbfutbolcu);
                hm.put(ENumRest.status,true);
                hm.put(ENumRest.result, dbfutbolcu);
            }else{
                hm.put(ENumRest.status,false);
            }
        }else{
            hm.put(ENumRest.status,false);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity teamCreate( int teamMemberA, int teamMemberB){
        Map<ENumRest, Object> hm = new LinkedHashMap<>();






        return new ResponseEntity(hm, HttpStatus.OK);
    }


}