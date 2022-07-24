package com.works.productrestapihomework.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Length(min = 3, max = 40, message = "Minimum 3 karakter, maksimum 40 karakter yazılabilir.")
    private String title;

    private String detail;

    @Min(value = 10)
    private int price;


}
