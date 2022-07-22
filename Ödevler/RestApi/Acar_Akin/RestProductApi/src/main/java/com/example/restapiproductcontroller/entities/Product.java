package com.example.restapiproductcontroller.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer pid;


    @Length(min = 3, max = 40, message = "Başlık Min 3 Max 40 karakter olmalıdır.")
    @NotBlank
    private String title;


    private String detail;

    @Min(value = 10 , message = "Fiyat en az 10 TL olmalıdır.")
    private double price;

}
