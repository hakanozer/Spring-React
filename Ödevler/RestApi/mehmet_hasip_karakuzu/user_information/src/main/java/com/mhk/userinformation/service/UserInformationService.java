package com.mhk.userinformation.service;

import com.mhk.userinformation.props.UserInformation;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserInformationService {


  private final RestTemplate template;

  public UserInformationService(RestTemplate template) {
    this.template = template;
  }


  public ResponseEntity getUser(String id) {
    Map<String, Object> hm = new LinkedHashMap();
    String basePath = "https://jsonplaceholder.typicode.com/users/" + id;

    UserInformation response = template.getForObject(basePath, UserInformation.class);
    hm.put("status", true);
    hm.put("user", response);
    return new ResponseEntity(hm, HttpStatus.OK);
  }

  public ResponseEntity getAllUsers() {

    String basePath = "https://jsonplaceholder.typicode.com/users";

    //UserInformation[] response = template.getForObject(basePath, UserInformation[].class);
    List<UserInformation> response = template.getForObject(basePath, List.class);
    Map<String, Object> hm = new LinkedHashMap();
    hm.put("status", true);
    hm.put("users", response);

    return new ResponseEntity(hm, HttpStatus.OK);
  }


}
