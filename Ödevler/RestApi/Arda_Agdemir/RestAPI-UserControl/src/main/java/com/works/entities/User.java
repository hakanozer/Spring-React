package com.works.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.boot.autoconfigure.mail.MailProperties;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @Length(min = 3, max = 13, message = "Name is not valid")
    @Column(nullable = false)
    private String name;

    @Length(min = 3, max = 13, message = "Surname is not valid")
    @Column(nullable = false)
    private String surname;

    @Email//(regexp = "\"^[a-zA-Z0-9_+&*-]+(?:\\\\.\" +\"[a-zA-Z0-9_+&*-]+)*@\" + \"(?:[a-zA-Z0-9-]+\\\\.)+[a-zA-Z]{2,7}$\"")
    private String email;

    @NotNull
    private String password;


}
