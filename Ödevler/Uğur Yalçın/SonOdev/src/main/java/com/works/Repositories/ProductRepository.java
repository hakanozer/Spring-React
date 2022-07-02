package com.works.Repositories;

import com.works.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByTitleContainsIgnoreCaseOrDetailContainsIgnoreCase(String title, String detail);
    int countAllBy();


}
