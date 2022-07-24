package com.works.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
@Data
public class TeamsJoin {
    @Id
    private Integer tid;

    private Integer fid;
    private String team;
    private String name;
    private String surname;
    private int age;
}
