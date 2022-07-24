package com.works.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Data
public class Gamer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gamerID;

    private Integer teamID;

    @NotEmpty
    private String name;

    @NotEmpty
    private String surname;

    @NotEmpty
    @Column(unique = true)
    @Email(message = "email formatına uygun olmalıdır")
    private String email;

    private String password;

    @Min(message = "oyuncu yaşı en az 18 olmalıdır", value = 18)
    private Integer age;


    @OneToOne
    private Teams teams;









}
