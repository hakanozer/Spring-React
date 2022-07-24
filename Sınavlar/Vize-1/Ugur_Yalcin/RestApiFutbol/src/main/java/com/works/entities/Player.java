package com.works.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pid;

    private String name;
    private String surname;
    private String email;
    private String password;
    private Integer age;
    private String team;



}
