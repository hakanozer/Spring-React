package com.works.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private Integer id;
    private String title;
    private String detail;
    private Integer price;

}
