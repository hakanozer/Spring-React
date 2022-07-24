package com.works.services;

import com.works.entities.Footballer;
import com.works.repositories.FootballerRepository;
import com.works.utils.REnum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class FootballerService {

    final FootballerRepository fRepo;
    public FootballerService(FootballerRepository fRepo) {
        this.fRepo = fRepo;
    }

    public ResponseEntity save(Footballer footballer) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        try {
            fRepo.save(footballer);
            hm.put( REnum.status, true );
            hm.put( REnum.message, "Kayıt işlemi başarılı" );
            hm.put( REnum.result, footballer );
        }catch (Exception ex) {
            hm.put( REnum.status, false );
            hm.put( REnum.message, "Bu mail ile daha önce kayıt yapılmış" );
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity allSave(List<Footballer> footballers) {
        Map<REnum, Object> hm = new LinkedHashMap<>();
        for ( Footballer item : footballers ) {
            fRepo.save(item);
        }
        hm.put( REnum.status, true );
        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
