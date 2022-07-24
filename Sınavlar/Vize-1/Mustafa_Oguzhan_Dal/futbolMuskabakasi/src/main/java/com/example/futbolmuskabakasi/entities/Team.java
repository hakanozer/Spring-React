package com.example.futbolmuskabakasi.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class Team {
    @Id
    private int tid;
    private String team_name;
}
