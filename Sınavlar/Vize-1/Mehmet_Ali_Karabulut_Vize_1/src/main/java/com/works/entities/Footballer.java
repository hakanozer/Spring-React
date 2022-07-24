package com.works.entities;


import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.core.SpringVersion;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Footballer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fid;

    private String name;
    private String surname;

    @NotBlank(message = "Mail alani bos birakilamaz.")
    @Column(unique = true, length = 150)
    private String mail;

    @Column(length = 32)
    private String password;

    @NotNull(message = "Yas bos birakilamaz.")
    @Min(value = 17, message = "Yas 18'den kucuk olamaz")
    private Integer age;

    @NotNull(message = "Takım adi bos birakilamaz.")
    @Column(unique = true)
    private String team;
}
