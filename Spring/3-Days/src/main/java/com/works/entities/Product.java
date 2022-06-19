package com.works.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
public class Product {

    private Integer id;

    @NotBlank(message = "Title Kesinlikle Gerekli")
    @Length(min = 3, max = 30, message = "Başlık Min 3 Max 30 karakter olmalıdır.")
    private String title;

    @NotBlank(message = "Detail Kesinlikle Gerekli")
    private String detail;

    @Min(value = 1, message = "Fiyat en az 1 olmalıdır.")
    @Max(value = 10000, message = "Fiyat en fazla 10000 olmalıdır.")
    private Integer price;

}
