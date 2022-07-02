package com.mhk.productmanager.repository;

import com.mhk.productmanager.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

  List<Product> findByTitleContainsIgnoreCaseOrDetailsContainsIgnoreCase(String title,
      String details);



  List<Product> findByPriceGreaterThanEqual(double price);


  int countAllBy();
}
