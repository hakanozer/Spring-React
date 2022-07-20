package com.works.services;

import com.works.props.users.JsonUser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
public class UserService {

    final RestTemplate template;
    public UserService(RestTemplate template) {
        this.template = template;
    }

    public ResponseEntity singleUser(String id) {
        Map<String, Object> hm = new LinkedHashMap();

        String url = "https://jsonplaceholder.typicode.com/users/"+id;
        JsonUser user = template.getForObject(url, JsonUser.class);

        hm.put("status", true);
        hm.put("result", user.getName());

        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity allUser() {
        Map<String, Object> hm = new LinkedHashMap();

        String url = "https://jsonplaceholder.typicode.com/users";
        //Set<JsonUser> users = template.getForObject(url, LinkedHashSet.class);
        List<JsonUser> users = template.getForObject(url, List.class);

        hm.put("status", true);
        hm.put("result", users);

        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
