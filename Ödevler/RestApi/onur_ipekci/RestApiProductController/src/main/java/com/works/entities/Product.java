package com.works.entities;

import lombok.Data;
import org.hibernate.validator.constraints.Length;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;


@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    @NotBlank(message = "Title Kesinlikle Gerekli")
    @Length(min=3,max=30,message="Başlık Min 3 Max 30 karakter olmadılır.")
    private String title;

    @NotBlank(message = "Title Kesinlikle Gerekli")
    @Length(min=3,max=30,message="Başlık Min 3 Max 30 karakter olmadılır.")
    private String detail;

    @Min(value = 10,message = "Fiyat en az 10 olmalıdır.")
    private int price;

}
