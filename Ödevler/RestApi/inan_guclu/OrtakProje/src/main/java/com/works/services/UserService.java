package com.works.services;


import com.works.props.UserDatum;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    final RestTemplate restTemplate;


    public UserService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity allUser(){
        Map<String,Object> hm= new LinkedHashMap<>();

        String url = "https://jsonplaceholder.typicode.com/users";
        List<UserDatum> users= restTemplate.getForObject(url,List.class);

        hm.put("status",true);
        hm.put("result",users);


        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity singleUser(String id) {
        Map<String,Object> hm = new LinkedHashMap<>();
        String url = "https://jsonplaceholder.typicode.com/users/"+id;
        UserDatum user=restTemplate.getForObject(url,UserDatum.class);
        hm.put("status", true);
        hm.put("result", user);


        return new ResponseEntity(hm,HttpStatus.OK);
    }




}
