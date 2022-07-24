package com.example.futbolmuskabakasi.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Footballer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fid;
    private Integer tid;

    private String name;
    private String lastname;
    private String email;
    @NotNull
    @Min(message = "18 Yaşından küçükler kayıt olamaz", value = 18)
    @Column(nullable = false)
    private Integer age;
    private String password;

}