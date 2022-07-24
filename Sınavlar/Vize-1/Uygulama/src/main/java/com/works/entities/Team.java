package com.works.entities;

import com.works.utils.TEnum;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    @Column(unique = true)
    private Integer fid;

    //@Enumerated(EnumType.STRING)
    private TEnum name;

}
