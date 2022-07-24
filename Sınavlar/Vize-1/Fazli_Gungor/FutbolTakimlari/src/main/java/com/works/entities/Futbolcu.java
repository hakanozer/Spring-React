package com.works.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Entity
public class Futbolcu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int fid;

    private String name;
    private String surname;
    @Email
    @NotBlank
    @Column(unique = true)
    private String email;
    @NotBlank
    private String password;
    private Integer age;
    private Integer tid;

}
