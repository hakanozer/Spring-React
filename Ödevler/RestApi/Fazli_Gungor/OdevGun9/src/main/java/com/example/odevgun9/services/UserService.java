package com.example.odevgun9.services;

import com.example.odevgun9.props.users.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class UserService {
    final RestTemplate restTemplate;

    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    //TODO: 1-Neden tek basına CompanyRestCOntrollerı cagırdıgım zaman butun verıler gelıyor?
    //TODO: 2-user'da sadece company ısımlerıını gormek ıstıyorum
    public ResponseEntity getAllUsers() {
        Map<String, Object> hm = new LinkedHashMap();
        String url = "https://jsonplaceholder.typicode.com/users";

        List<User> user = restTemplate.getForObject(url, List.class);

        hm.put("status", true);
        hm.put("result", user);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity singleUser(String id) {
        Map<String, Object> hm = new LinkedHashMap();
        String url = "https://jsonplaceholder.typicode.com/users" + id;
        User user = restTemplate.getForObject(url, User.class);

        hm.put("status", true);
        hm.put("result", user);
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
