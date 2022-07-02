package com.works.repository;

import com.works.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Optional<Product> findByPidEquals(int pid);

    List<Product> findByTitleContainsIgnoreCaseAndDetailContainsIgnoreCase(String title, String detail);
    Object countAllBy();

    List<Product> findByPriceGreaterThanEqual(int price);


}
