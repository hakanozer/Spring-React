package com.works.futbolmusabakasirestapi.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
public class Footballer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fid;

    @Max(2)
    @Min(1)
    @Column(nullable = false)
    private int tid;

    private String name;

    private String surname;

    @Min(message = "18 yasindan kucukler kayit olamaz !", value = 18)
    @Column(nullable = false)
    private int age;

    @Column(unique = true)
    @NotBlank
    @Email
    private String email;

    @Length(min = 5, max = 32)
    @Column(unique = true)
    private String password;


}
