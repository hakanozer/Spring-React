package com.works.entities;


import lombok.Data;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;
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
    private Integer pid;

    @Length(min=3, max = 40)
    @NotBlank
    private String title;

    private String detail;

    @Min(value = 10)
    private Double price;

}
