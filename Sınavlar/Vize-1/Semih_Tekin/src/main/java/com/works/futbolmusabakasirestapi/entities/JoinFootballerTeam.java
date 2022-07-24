package com.works.futbolmusabakasirestapi.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class JoinFootballerTeam {

    @Id
    private int fid;

    private int tid;

    private String name;

    private String surname;

    private int age;

    private String teamName;

}
