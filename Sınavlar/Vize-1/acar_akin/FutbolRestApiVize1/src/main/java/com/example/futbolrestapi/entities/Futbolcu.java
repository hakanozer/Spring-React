package com.example.futbolrestapi.entities;

import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Data
public class Futbolcu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fid;


    private Integer tid;

    private String name;
    private String surname;



    @Email
    private String email;


    private String password;

    @Min(value = 18, message = "Yaş en az 18 ve üstü olmalıdır! ")
    public Integer age;

    @ManyToMany
    private List<JoinFutbolcuTakim> joinFutbolcuTakim;
}
