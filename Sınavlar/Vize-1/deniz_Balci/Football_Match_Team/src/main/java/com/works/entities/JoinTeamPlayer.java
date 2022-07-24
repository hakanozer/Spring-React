package com.works.entities;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;


@Entity
@Data
public class JoinTeamPlayer {

    @Id
    private Integer tid;
    @NotNull
    private Integer fid;
    private String team;
    private String name;
    private String surname;
    private int age;
}
