package com.works.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(unique = true, length = 150)
    private String email;

    private int age;
    @Column(length = 32)
    private String password;

}
