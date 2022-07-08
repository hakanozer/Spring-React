package com.works.entities;

import lombok.Data;
import org.hibernate.validator.constraints.CodePointLength;
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

        @NotBlank
        @Length(min = 3, max = 13)
        private String name;
        @NotBlank
        @Length(min = 3, max = 13)
        private String surname;
        @Email(message = "Please, Enter valid eMail Adress")
        @Column(unique = true)
        private String email;
        private String password;

}
