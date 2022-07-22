package com.work.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class UserPerson {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;

    @Length(min=3, max = 13)
    private String name;


    @Length(min=3, max = 13)
    @NotBlank
    private String surname;

    @Email
    private String email;

    private String password;
}
