package com.example.futbolmuskabakasi.entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

@Entity
@Data
public class JoinTeamtoFootballer {
    @Id
    private int fid;
    private Integer tid;
    private String team_name;
    private String name;
    private String lastname;
    private String email;
    private int age;
}
