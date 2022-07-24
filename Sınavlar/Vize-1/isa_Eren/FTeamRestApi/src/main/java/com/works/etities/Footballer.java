package com.works.etities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@Entity
public class Footballer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fid;
    @Length(min = 3, max = 30, message = "Ad Min 3 Max 30 karakter olmalıdır.")
    private String fName;
    @Length(min = 3, max = 30, message = "Soyad Min 3 Max 30 karakter olmalıdır.")
    private String surname;
    @Email(message = "email formatı uygun yazılmalıdır.")
    @NotBlank(message = "Email gerekli")
    @Column(unique = true)
    private String email;
    @Length(min = 3, max = 30, message = "Soyad Min 3 Max 30 karakter olmalıdır.")
    private String password;
    @Min(value = 18, message = "Futbolcu yaşı minimum 18 olmalıdır.")
    private Integer age;
    @ManyToOne()
    private Team team;
}
