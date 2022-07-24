package com.works.springvize1.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
@Data
public class Teams {
    @Id
    @GeneratedValue
    private Integer tid;
    private String teamName;

    @OneToOne
    private Player players;
}
