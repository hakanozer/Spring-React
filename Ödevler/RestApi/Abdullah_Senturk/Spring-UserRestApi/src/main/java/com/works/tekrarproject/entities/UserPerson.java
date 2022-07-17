package com.works.tekrarproject.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Data
// getter-setter'ların arkaplanda otomatik olarak kurulmasını sağlar.
public class UserPerson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @NotBlank
    @Length(min = 3, max = 13, message = "Name is not valid!")
    private String name;

    @NotBlank
    @Length(min = 3, max = 13, message = "Surname is not valid!")
    private String surname;

    @Column(unique = true)
    // repository içerisine boolean existsByEmailEqualsIgnoreCase(String email) yazmazsak try-catch denetimi
    // yapmak zorunda kalırız!
    @Email
    // email ile ilgili gereken kontrolleri yapar. Detaylı kontrol için JPA Inspector
    // içerisindeki Regexp kullanılabilir
    private String email;

    @Length(max = 32) // Bu denetim yapılmasa da olurdu çünkü xampp'te veritabanında bu sınırlama zaten var
    private String password;

}
