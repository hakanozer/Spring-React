package com.works.entities;

import lombok.Data;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Validated
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fid;

    @NotNull
    private String name;
    @NotNull
    private String surname;



    @Email
    @NotBlank
    @Column(unique = true)
    private String email;

    @Min(18)
    @Column(nullable = false)
    private int age;

    @NotBlank
    private String password;
}
