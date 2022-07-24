package com.works.services;

import com.works.entities.Product;
import com.works.repositories.JoinProCatRepository;
import com.works.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ProductService {
    final ProductRepository pRepo;
    final JoinProCatRepository jRepo;
    public ProductService(ProductRepository pRepo, JoinProCatRepository jRepo) {
        this.pRepo = pRepo;
        this.jRepo = jRepo;
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
        hm.put("result", jRepo.allProduct() );
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity search( String q ) {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        hm.put("result", jRepo.searchProduct( "%" + q + "%" ));
        return new ResponseEntity(hm, HttpStatus.OK);
    }




}
