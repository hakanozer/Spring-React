package com.example.product.Entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;


@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer ProductID;


    @Length(message = "title 3-10 arasındadır.", min = 3, max = 10)
    private String title;
    private String detail;
    @Min(message = "En düsük 10 tl olmalıdır.", value = 10)
    private Integer price;

}

















