package com.works.productprojem.entities;

import lombok.Data;


import javax.persistence.*;

@Entity
@Data
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int productID;

    private String title;
    private String detail;
    private int price;




}
