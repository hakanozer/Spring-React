package com.works.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Data
@AllArgsConstructor
public class User {

    private int id;
    private String name;
    private String surname;
    private String email;

}
