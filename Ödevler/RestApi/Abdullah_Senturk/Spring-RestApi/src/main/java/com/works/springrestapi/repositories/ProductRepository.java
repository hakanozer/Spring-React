package com.works.springrestapi.repositories;

import com.works.springrestapi.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findByTitleEqualsIgnoreCaseOrDetailEqualsIgnoreCase(String title, String detail);

    List<Product> findByPriceGreaterThanEqual(Integer price);
    int countAllBy();
}
