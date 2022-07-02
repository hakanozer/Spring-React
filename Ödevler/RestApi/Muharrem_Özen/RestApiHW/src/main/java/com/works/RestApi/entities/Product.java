package com.works.RestApi.entities;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Data
public class Product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pid;

    @Length(min = 3,max = 40,message = "En az 3 en fazla 40 karekter yazılmalıdır!")
    private String title;

    private String detail;

    @Min (value = 10)
    private int price;



}
