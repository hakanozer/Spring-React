package com.works.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
@Data
public class Team {
    @Id
    private int tid;

    private String takımAdı;



    @OneToMany
    private List<Footballer> footballers;


}
