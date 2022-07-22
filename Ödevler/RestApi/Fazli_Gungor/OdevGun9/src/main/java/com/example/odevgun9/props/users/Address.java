
package com.example.odevgun9.props.users;

import lombok.Data;

import javax.annotation.Generated;

@Generated("jsonschema2pojo")
@Data
public class Address {

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private Geo geo;
    //private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  
}
