package com.works.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Data
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fid;

    @NotNull(message = "This value is absolutely necessary!")
    @Min(value = 1, message = "This value must be at least 1!")
    @Max(value = 2, message = "This value must be at most 2!")
    private Integer tid;

    @NotBlank
    @Length(min = 2, max = 13, message = "Name is not valid!")
    private String name;

    @NotBlank
    @Length(min = 2, max = 13, message = "Surname is not valid!")
    private String surname;

    @Column(unique = true)
    @NotBlank(message = "Email is absolutely necessary!")
    @Email
    private String email;

    @NotBlank(message = "Password is absolutely necessary!")
    @Length(min = 4, max = 32)
    private String password;

    @NotNull
    @Min(value = 18, message = "The age must be at least 18!")
    private Integer age;

}
