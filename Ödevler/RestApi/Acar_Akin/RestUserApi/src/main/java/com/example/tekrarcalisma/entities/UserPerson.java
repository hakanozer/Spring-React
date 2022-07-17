package com.example.tekrarcalisma.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;


@Entity
@Data
public class UserPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;


    @Length(min = 3, max = 13, message = "İsim Min 3 Max 13 karakter olmalıdır.")
    @NotBlank
    private String name;


    @Length(min = 3, max = 13, message = "Soyisim Min 3 Max 13 karakter olmalıdır.")
    @NotBlank
    private String surname;


    @Column(unique = true)
    @Email(message = "Bu mail halihazırda kullanılıyor!")
    private String email;



    @Length(min = 6, max = 30)
    private String password;

}
