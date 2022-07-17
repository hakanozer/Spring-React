package com.works.product_restapi.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table(name = "product")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;

    @NotBlank(message = "Title is not null")
    @Length(min = 3, max = 40, message = "The title must be at least 3 characters and at most 40 characters.")
    private String title;

    @NotBlank(message = "Detail is not null")
    private String detail;

    @NotNull(message = "Price is not null")
    @Min(value=10, message = "The price cannot be less than 10.")
    private Integer price;

}
