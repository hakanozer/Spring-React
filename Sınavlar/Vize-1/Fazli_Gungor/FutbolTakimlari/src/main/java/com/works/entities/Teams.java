package com.works.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Data
@Entity
public class Teams {

    @Max(2)
    @Min(1)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private int tid;
    private String teamname;

    @OneToMany
    private List<Futbolcu> futbolcuList;

}
