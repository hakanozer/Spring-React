package com.example.odevgun9.services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class CompanyService {

    final RestTemplate restTemplate;

    public CompanyService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity singleCompany(){
        Map<String, Object> hm = new LinkedHashMap();

        String url = "";


        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
