package com.works.services;

import com.works.entities.Admin;
import com.works.repositories.AdminRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class AdminService {

    final AdminRepository aRepo;
    public AdminService(AdminRepository aRepo) {
        this.aRepo = aRepo;
    }

    public ResponseEntity save(Admin admin) {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        hm.put("result", aRepo.save(admin) );
        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
