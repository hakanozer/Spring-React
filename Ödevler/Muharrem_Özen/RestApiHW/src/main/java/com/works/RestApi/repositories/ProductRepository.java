package com.works.RestApi.repositories;

import com.works.RestApi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository <Product,Integer> {
    List<Product> findByTitleContainsIgnoreCaseOrDetailContainsIgnoreCase(String title, String detail);

    List<Product> findByPriceGreaterThanEqual(int price);



    int countAllBy();

}
