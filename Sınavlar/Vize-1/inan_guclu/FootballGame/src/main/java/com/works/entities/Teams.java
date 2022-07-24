package com.works.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
public class Teams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tID;

    private String teamName;

    private Integer gamerID;


    @OneToOne
    @JoinColumn(name = "gamerID",nullable = false)
    private Gamer gamers;




}
