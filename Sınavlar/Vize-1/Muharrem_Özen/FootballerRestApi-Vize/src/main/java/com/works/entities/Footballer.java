package com.works.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Footballer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fid;

    private String name;
    private String surname;

    @NotBlank
    @Column(unique = true)
    private String email;

    @Min(value=18,message = "Yaş en az 18 olmalıdır.")
    private int age;

    private String password;


    @ManyToOne
    private Team team;


}
