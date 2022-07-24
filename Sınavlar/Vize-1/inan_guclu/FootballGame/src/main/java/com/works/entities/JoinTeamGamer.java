package com.works.entities;

import lombok.Data;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class JoinTeamGamer {

    @Id
    private Integer gamerID;
    private Integer teamID;
    private String teamName;
    private String name;
    private String lastName;
    private String email;
    private Integer age;

}
