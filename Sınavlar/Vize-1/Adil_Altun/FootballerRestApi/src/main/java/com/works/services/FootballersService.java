package com.works.services;

import com.works.entities.Footballers;
import com.works.repositories.FootballersRepository;
import com.works.repositories.JoinTeamsToFootballersRepository;
import com.works.utils.ERest;
import com.works.utils.Util;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class FootballersService {
    final FootballersRepository footballerRepository;
    final JoinTeamsToFootballersRepository joinTeamsToFootballersRepository;

    public FootballersService(FootballersRepository footballerRepository, JoinTeamsToFootballersRepository joinTeamsToFootballersRepository) {
        this.footballerRepository = footballerRepository;
        this.joinTeamsToFootballersRepository = joinTeamsToFootballersRepository;
    }


    public ResponseEntity footballerRegister(Footballers footballer){
        Map<ERest,Object> hm = new LinkedHashMap<>();
        footballer.setPassword(Util.md5(footballer.getPassword()));
        if (footballer.getTid()>0 && footballer.getTid()<=2 ){
            hm.put(ERest.status,true);
            hm.put(ERest.result,footballerRepository.save(footballer));
        }else {
            hm.put(ERest.status,false);
            hm.put(ERest.message,"Tid 1 ya da 2 olmalıdır"); //(1- A takımı)------(2- B Takımı)
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity teamInsert (int fid,int tid){
        Map<ERest,Object> hm = new LinkedHashMap<>();
        Footballers footballers = new Footballers();
        Optional<Footballers> optionalFootballers = footballerRepository.findById(fid);
        if (optionalFootballers.isPresent()){
            if (joinTeamsToFootballersRepository.count(tid)<=2){
                Footballers dbfootballers = optionalFootballers.get();
                dbfootballers.setTid(tid);
                footballerRepository.saveAndFlush(dbfootballers);
                hm.put(ERest.status,true);
                hm.put(ERest.result,dbfootballers);
            }else {
                hm.put(ERest.status,false);
                hm.put(ERest.message,"Dolu");
            }
        }else {
            hm.put(ERest.status,false);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity teamCreate(int teamMembers){
        Map<ERest,Object> hm = new LinkedHashMap<>();
        joinTeamsToFootballersRepository.findByTidIsNotNullAllIgnoreCaseOrderByAgeAsc(teamMembers);
        Footballers footballers = new Footballers();
            if (teamMembers==1){
                footballers.setTid(1);
                hm.put(ERest.status,true);
                hm.put(ERest.result,footballers);
            }else if (teamMembers==2){
                footballers.setTid(2);
                hm.put(ERest.status,true);
                hm.put(ERest.result,footballers);
            }else {
                hm.put(ERest.status,false);
                hm.put(ERest.message,"Fail");
                return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
            }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
