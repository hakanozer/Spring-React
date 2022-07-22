
package com.example.odevgun9.props.users;

import lombok.Data;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
@Data
public class User {

    private Integer id;
    private String name;
    private String username;
    private String email;
    private Address address;
    private String phone;
    private String website;
    private Company1 company;
    //private Map<String, Object> additionalProperties = new HashMap<String, Object>();

}