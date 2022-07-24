package com.works.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
public class Footballers {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fid;

    private Integer tid;

    @NotBlank(message = "Name parametresi yazılmalıdır.")
    private String name;
    @NotBlank(message = "Surname parametresi yazılmalıdır.")
    private String surname;

    @Email
    @Column(unique = true)
    private String email;

    @NotEmpty
    @Length(max = 32, message = "32 karakter olmalıdır.")
    private String password;

    @Min(value = 18,message = "Yaş en az 18 olmalıdır.")
    private Integer age;

    @ManyToMany
    private List<JoinTeamsToFootballers> joinTeamsToFootballers;


}
