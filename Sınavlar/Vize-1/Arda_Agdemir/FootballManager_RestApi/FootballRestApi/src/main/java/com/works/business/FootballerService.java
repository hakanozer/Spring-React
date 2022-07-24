package com.works.business;

import com.works.entities.Footballer;
import com.works.entities.JoinFT;
import com.works.repositories.FootballerRepository;
import com.works.repositories.JoinFTRepository;
import com.works.utilities.ERest;
import com.works.utilities.PasswordConvert;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.works.utilities.ERest.*;

@Service
public class FootballerService {

    final FootballerRepository fRepository;
    final JoinFTRepository jRepository;

    public FootballerService(FootballerRepository footballerRepository, JoinFTRepository joinFTRepository) {
        this.fRepository = footballerRepository;
        this.jRepository = joinFTRepository;
    }

    public ResponseEntity list(){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.result, fRepository.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }
    public ResponseEntity save(Footballer footballer) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        String newPass = PasswordConvert.md5(footballer.getPassword());
        footballer.setPassword(newPass);
        fRepository.save(footballer);
        hm.put(ERest.status, true);
        hm.put(ERest.result, footballer);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity teamCreate() {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        List<JoinFT> ftList = new ArrayList<>();
        hm.put(ERest.status, true);
        for(int i = 0; i<=10; i++){
            ftList.add(jRepository.getAllData("%A%").get(i));
        }
        for(int i = 0; i<=10; i++){
            ftList.add(jRepository.getAllData("%B%").get(i));
        }

        hm.put(result, ftList);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity backUpCreate(){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.status, true);

        List<JoinFT> ftList = new ArrayList<>();
        for(int i = 11; i<=15; i++){
            ftList.add(jRepository.getAllData("%A%").get(i));
            ftList.add(jRepository.getAllData("%B%").get(i));
        }
        hm.put(result, ftList);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
