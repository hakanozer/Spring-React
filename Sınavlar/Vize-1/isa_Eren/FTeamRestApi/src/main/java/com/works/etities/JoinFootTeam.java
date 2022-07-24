package com.works.etities;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class JoinFootTeam {
    @Id
    private Integer fid;
    private Integer tid;
    private String tName;
    private String fName;
}
