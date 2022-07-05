package com.example.product.Repositories;

import com.example.product.Entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer>{

    List<Product> findByTitleContainsIgnoreCaseOrDetailContainsIgnoreCase(String title, String detail);


    List<Product> findByPriceGreaterThanEqual(Integer price);
    }




