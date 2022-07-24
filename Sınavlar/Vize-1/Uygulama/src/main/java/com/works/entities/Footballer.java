package com.works.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Footballer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fid;

    @NotBlank(message = "Lütfen Adınızı giriniz")
    private String name;

    @NotBlank(message = "Lütfen soyad giriniz!")
    private String surname;

    @Column(unique = true)
    @Email(message = "Email Formatı hatalı")
    private String email;

    private String password;
    
    @Min(message = "Lütfen 18 yaş ve üstü değer giriniz!", value = 18)
    private Integer age;

}
