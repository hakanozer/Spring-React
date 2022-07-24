package com.works.springvize1.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
@Entity
@Data
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer Pid;
    private Integer tid;
    private String name;
    private String surname;
    @Column(unique = true)
    @NotEmpty(message = "email boş deper alamaz")
    @Email(message = "Email'i formatına uygun olacaktır.")
    private String email;
    @Length
    private String password;
    @Min(message = "oyuncunun yaşı en az 18 olmalıdır",value = 18)
    private Integer age;

    @OneToOne
    private Teams teams;
}


