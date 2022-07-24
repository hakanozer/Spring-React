package com.works.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class FootballPlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fid;

    private String name;
    private String surname;
    @NotNull
    @Email
    @Column(unique = true)
    private String email;
    private String password;
    @Min(18)
    @Column(nullable = false)
    private int age;
}
