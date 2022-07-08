package com.example.restapiproductcontroller.repositories;

import com.example.restapiproductcontroller.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {

    List<Product> findByTitleContainsIgnoreCaseOrDetailContainsIgnoreCase(String title, String detail);


    List<Product> findByPriceGreaterThanEqual(double price);


    int countAllBy();

}
