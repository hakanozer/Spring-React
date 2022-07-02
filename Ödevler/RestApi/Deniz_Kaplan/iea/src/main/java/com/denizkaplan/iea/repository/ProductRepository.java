package com.denizkaplan.iea.repository;

import com.denizkaplan.iea.entitiy.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findByTitleContainsIgnoreCaseOrDetailContainsIgnoreCase(String title, String detail);

    List<Product> findByPriceIsGreaterThanEqual(int price);








}
