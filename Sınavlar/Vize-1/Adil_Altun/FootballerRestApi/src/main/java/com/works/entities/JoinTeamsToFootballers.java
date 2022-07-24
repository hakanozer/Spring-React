package com.works.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class JoinTeamsToFootballers {

    @Id
    private Integer fid;
    private Integer tid;
    private String teamName;
    private String name;
    private String surname;
    private String email;
    private String age;

    @ManyToMany
    private List<Footballers> footballers;


}
