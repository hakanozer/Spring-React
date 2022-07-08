package com.works.productprojem.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;


import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Data
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productID;

    @Length(message = "title 3-10 deger arasında olmalıdır.", min = 3, max = 10)
    private String title;


    private String detail;


    @Min(message = "fiyat en az 10 tl olmalıdır ", value = 10)
    private Integer price;




}
