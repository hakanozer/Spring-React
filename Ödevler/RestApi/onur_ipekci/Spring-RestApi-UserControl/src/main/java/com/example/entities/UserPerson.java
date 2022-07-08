package com.example.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Data
public class UserPerson {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;


    @Length(min=3,max=15)
    private String name;

    @Length(min=3,max=15)
    private String surname;

    @Column(unique = true)
    @Email
    private String email;


    private String password;

}
