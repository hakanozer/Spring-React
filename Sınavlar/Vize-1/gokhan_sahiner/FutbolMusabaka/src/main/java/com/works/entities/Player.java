package com.works.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Data
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    private String name;
    private String surname;

    @Column(unique = true, length = 150)
    private String email;

    @Min(value = 18, message = "18 yaşından küçükler katılamaz")
    private Integer age;
    @Column(length = 32)
    private String password;
}
