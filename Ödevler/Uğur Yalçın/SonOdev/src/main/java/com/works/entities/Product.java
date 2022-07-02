package com.works.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;
    //@Length(message = "Please Enter Minimum 3 Maximum 40 Characters", min = 3, max = 40)
    private String title;
    private String detail;
    // @Length(message = "Please Enter Minimum 10", min = 10)
    private int price;

    // NOT: 15. ve 18. satırda @Length hata veriyor.
    // title ve detail'in üstüne maus ile gelince sağ alt tarafda JPA Inspector kısmında gözükmesi lazım fakat gözükmüyor.
}
