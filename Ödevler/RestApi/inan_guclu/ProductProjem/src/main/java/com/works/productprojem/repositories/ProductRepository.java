package com.works.productprojem.repositories;

import com.works.productprojem.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByTitleContainsIgnoreCaseOrDetailContainsIgnoreCase(String title, String detail);


    List<Product> findByPriceGreaterThanEqual(Integer price);


}
