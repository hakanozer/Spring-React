package com.works.repositories;

import com.works.entities.Product;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    @Query("select p from Product p where p.cid = ?1")
    List<Product> allProCatID(Integer cid);

    @Query("select p from Product p where p.price > ?1")
    List<Product> findByPriceGreaterThan(Integer price, Pageable pageable);

    @Query("select p from Product p order by p.pid DESC, p.price DESC")
    List<Product> findByOrderByPidDescPriceDesc();


}