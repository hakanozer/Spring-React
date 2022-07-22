package com.example.odevgun9.services;

import com.example.odevgun9.props.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    final String url = "https://jsonplaceholder.typicode.com/users";
    public ResponseEntity getAllUsers2() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<User>> response = restTemplate.exchange(url,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
                });
        List<User> rates = response.getBody();
        Map<String, Object> hm = new LinkedHashMap();
        hm.put("status", true);
        hm.put("result", rates);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity getId(int id) {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<List<User>> response = restTemplate.exchange(url,
                HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
                });

        List<User> rates = response.getBody();
        Map<String, Object> hm = new LinkedHashMap();
        hm.put("status", true);
        hm.put("result", rates.get(id - 1));
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
