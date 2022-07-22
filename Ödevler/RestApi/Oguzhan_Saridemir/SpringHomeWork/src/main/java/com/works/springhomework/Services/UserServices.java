package com.works.springhomework.Services;


import com.works.springhomework.props.JsonShema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServices {
    final RestTemplate restTemplate;

    public UserServices(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ResponseEntity AllUser() {
        Map<String, Object> hm = new LinkedHashMap<>();
        String url = "https://jsonplaceholder.typicode.com/users";
        RestTemplate template = new RestTemplate();
        List<JsonShema> users = template.getForObject(url, List.class);
        hm.put("status", true);
        hm.put("result", users);
        return new ResponseEntity(hm, HttpStatus.OK);


    }
    public ResponseEntity singleUser(String id){
        Map<String ,Object> hm=new LinkedHashMap<>();
        String url="https://jsonplaceholder.typicode.com/users/"+id;
        JsonShema user=restTemplate.getForObject(url,JsonShema.class);
        hm.put("status",true);
        hm.put("result",user);

        return new ResponseEntity(hm,HttpStatus.OK);
    }

}

