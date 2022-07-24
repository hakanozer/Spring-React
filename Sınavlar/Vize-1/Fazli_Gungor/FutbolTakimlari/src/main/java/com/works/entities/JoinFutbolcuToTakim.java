package com.works.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class JoinFutbolcuToTakim {

    @Id
    private int fid;

    private String name;
    private String surname;
    private String email;
    private String password;
    private String age;

    private int tid;

}
