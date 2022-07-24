package com.works.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class JoinPlayerTeams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer fid;

    private Integer tid;

    private String name;

    private String surname;

    private String email;

    private String password;

    private Integer age;

    private String teamName;

    @ManyToMany
    private List<Player> player;


}
