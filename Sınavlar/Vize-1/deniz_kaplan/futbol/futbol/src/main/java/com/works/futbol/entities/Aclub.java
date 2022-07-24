package com.works.futbol.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Aclub {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long cid;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="fid", nullable=false)

    Player player;
}
