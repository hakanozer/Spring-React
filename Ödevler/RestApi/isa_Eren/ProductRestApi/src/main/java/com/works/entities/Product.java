package com.works.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    @Length(min = 3,max = 40,message = "Title en az 3 en fazla 40 karakterden oluşmalıdır.")
    private String title;
    @Length(min = 3,max = 40,message = "Detail en az 3 en fazla 40 karakterden oluşmalıdır.")
    private String detail;
    @Min(value = 10,message = "Price en az 10 TL olmalıdır.")
    private double price;
}

