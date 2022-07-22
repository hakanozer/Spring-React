package com.example.userprojem.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Length(message = "isim uzunluğu 3 ile 20 karakter arasında olmalıdır", min = 3, max = 20)
    private String name;


    @Length(message = "soyisim uzunluğu 3 ile 20 karakter arasında olmalıdır", min = 3, max = 13)
    @NotBlank
    private String surname;

    @Column(unique = true)
    @Email(message = "email formatına uygun olmalıdır..")
    private String email;

    @Length(min = 32, max = 32)
    private String password;
}
