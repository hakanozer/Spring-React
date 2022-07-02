package com.denizkaplan.iea.entitiy;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;

    @NotBlank(message = "Title Kesinlikle Gerekli")
    @Length(min = 3, max = 30, message = "Başlık Min 3 Max 30 karakter olmalıdır.")
    private String title;

    private String  detail;

    @Min(value = 10, message = "Fiyat en az 1 olmalıdır.")
    private int price;
}
