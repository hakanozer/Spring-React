package com.works.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Teams {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;
    private Integer fid;
    private String teamName;

}
