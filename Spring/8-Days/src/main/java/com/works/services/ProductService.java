package com.works.services;

import com.works.entities.Category;
import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ProductService {

    final ProductRepository pRepo;
    public ProductService(ProductRepository pRepo) {
        this.pRepo = pRepo;
    }

    public ResponseEntity save(Product product) {
        Map<String, Object> hm = new LinkedHashMap<>();
        pRepo.save( product );
        hm.put("status", true);
        hm.put("result", product);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list() {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        hm.put("result", pRepo.findAll() );
        return new ResponseEntity(hm, HttpStatus.OK);
    }




}
