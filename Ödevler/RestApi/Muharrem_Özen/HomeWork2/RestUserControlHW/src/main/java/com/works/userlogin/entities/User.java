package com.works.userlogin.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;

    private String name;
    private String surname;

    @Column(length = 32)
    private String password;

    @Column(unique = true, length = 150)
    private String email;


}
