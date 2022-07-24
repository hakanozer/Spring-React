package com.works.springvize1.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Data
public class JoinTeamsPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer pid;
    private Integer tid;
    private Integer teamName;


}


