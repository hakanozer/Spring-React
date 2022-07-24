package com.works.entities;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Teams {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer tid;

    private Integer pid;
    private String teamName;


    @ManyToOne
    @JoinColumn(name="fid", nullable=false)
    private Player player;
}
