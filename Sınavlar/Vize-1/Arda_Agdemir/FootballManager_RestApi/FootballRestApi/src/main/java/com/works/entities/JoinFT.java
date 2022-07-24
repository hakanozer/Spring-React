package com.works.entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class JoinFT {

    @Id
    private Integer fid;
    private Integer tid;

    private String name;
    private String surname;
    private Integer age;
    private String teamName;
}
