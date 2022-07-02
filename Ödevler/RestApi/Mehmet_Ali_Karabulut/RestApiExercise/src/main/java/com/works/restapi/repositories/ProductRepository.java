package com.works.restapi.repositories;

import com.works.restapi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product,Integer> {

    List<Product> findByPriceGreaterThanEqual(int price);

    List<Product> findByTitleContainsIgnoreCaseOrDetailContainsIgnoreCase(String title, String detail);

    int countAllBy();

}
