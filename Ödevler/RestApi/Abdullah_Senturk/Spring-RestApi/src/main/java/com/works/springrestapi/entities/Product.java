package com.works.springrestapi.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    @NotBlank(message = "Title is absolutely necessary!")
    @Length(min = 3, max = 40, message = "The title must be min 3 max 40 characters!")
    private String title;

    @NotBlank(message = "Detail is absolutely necessary!")
    private String detail;

    @NotNull(message = "Price is absolutely necessary!")
    @Min(value = 10, message = "The price must be at least 10 TL!")
    private Integer price;

}
