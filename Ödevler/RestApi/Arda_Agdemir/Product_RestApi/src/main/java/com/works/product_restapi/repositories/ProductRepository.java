package com.works.product_restapi.repositories;


import com.works.product_restapi.entities.Product;
import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByTitleContainsIgnoreCaseOrDetailContainsIgnoreCase(@NonNull String title, String detail);
    List<Product> findByPriceGreaterThanEqual(@NonNull Integer price);

}
