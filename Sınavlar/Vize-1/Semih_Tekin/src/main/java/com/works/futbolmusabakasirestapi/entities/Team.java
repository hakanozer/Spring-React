package com.works.futbolmusabakasirestapi.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Entity
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int tid;

    private String teamName;

    @Max(16)
    @Column(nullable = false)
    private int teamCapacity;

    @ManyToMany
    private List<Footballer> footballers;



}
