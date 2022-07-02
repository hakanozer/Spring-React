package com.works.services;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {

    final ProductRepository pRepo;


    public ProductService(ProductRepository pRepo) {
        this.pRepo = pRepo;
    }

    public ResponseEntity save(Product product){
        Map<String,Object> hm = new HashMap<>();
        Product u = pRepo.save(product);
        hm.put("product",u);
        return new ResponseEntity(hm, HttpStatus.OK);
    }



}
