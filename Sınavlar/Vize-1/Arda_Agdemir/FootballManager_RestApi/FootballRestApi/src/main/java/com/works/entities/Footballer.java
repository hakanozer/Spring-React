package com.works.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;


@Data
@Entity
public class Footballer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fid;

    private String name;
    private String surname;

    @Email
    @Column(unique = true)
    private String email;

    @Column(length = 32)
    private String password;

    @Min(value = 18, message = "Yaşınız 18' de nbüyük olmalıdır.")
    private Integer age;
}
