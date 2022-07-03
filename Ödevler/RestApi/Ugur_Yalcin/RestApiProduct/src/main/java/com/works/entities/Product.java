package com.works.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Data

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    @Length(min = 3, max = 40)
    private String title;
    private String detail;
    @Min(10)
    @Column(nullable = false)
    private int price;

}
