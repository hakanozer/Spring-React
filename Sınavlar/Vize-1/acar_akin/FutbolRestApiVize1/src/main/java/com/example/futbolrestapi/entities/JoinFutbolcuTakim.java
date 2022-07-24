package com.example.futbolrestapi.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
public class JoinFutbolcuTakim {

    @Id
    private Integer fid;
    private Integer tid;
    private String teamName;
    private String name;
    private String surname;
    private String email;
    private String age;





}
