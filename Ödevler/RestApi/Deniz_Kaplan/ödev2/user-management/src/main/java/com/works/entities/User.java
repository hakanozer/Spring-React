package com.works.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@Table(name = "newusers")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int uid;

    @NotBlank(message = "boş bırakmayın")
    @Length(message = "lütfen 3 ile 20 arasında", min = 3, max = 13)
    private String name;

    @NotBlank(message = "boş bırakmayın")
    @Length(min = 3, max = 13)
    private String surname;

    @NotBlank(message = "boş bırakmayın")
    private String email;

    private  String password;
}
