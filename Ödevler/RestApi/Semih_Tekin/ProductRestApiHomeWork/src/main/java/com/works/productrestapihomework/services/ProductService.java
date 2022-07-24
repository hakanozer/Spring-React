package com.works.productrestapihomework.services;


import com.works.productrestapihomework.entities.Product;
import com.works.productrestapihomework.repositories.ProductRepository;
import com.works.productrestapihomework.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {

    final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity save(Product product){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Product p = productRepository.save(product);
        hm.put(ERest.status, true);
        hm.put(ERest.result, p);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list(){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.status, true);
        hm.put(ERest.result, productRepository.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity delete(String sid){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
            int id = Integer.parseInt(sid);
            productRepository.deleteById(id);
            hm.put(ERest.status, true);
            hm.put(ERest.message, sid+" numaralı id silindi!");
        }catch (Exception exception){
            hm.put(ERest.message, "Id request "+ sid);
            hm.put(ERest.status, false);
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity single(String sid){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
            int id = Integer.parseInt(sid);
            Optional<Product> optionalProduct = productRepository.findById(id);
            if (optionalProduct.isPresent()){
                hm.put(ERest.status, true);
                hm.put(ERest.result, optionalProduct.get());
            }else {
                hm.put(ERest.status, false);
                hm.put(ERest.message, "Empty!");
            }
        }catch (Exception exception){
            hm.put(ERest.message, "Id request "+ sid);
            hm.put(ERest.status, false);
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity update(Product product){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Optional<Product> optionalProduct = productRepository.findById(product.getId());
        if (optionalProduct.isPresent()){
            productRepository.saveAndFlush(product);
            hm.put(ERest.status, true);
            hm.put(ERest.result, product);
        }else{
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Fail id");
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity search ( String q ){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        List<Product> productList = productRepository.findByTitleContainsIgnoreCaseOrDetailContainsIgnoreCase(q, q);
        hm.put(ERest.total, productRepository.countAllBy());
        hm.put(ERest.searchTotal, productList.size());
        hm.put(ERest.status, true);
        hm.put(ERest.result, productList);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity searchByPrice(int q){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        List<Product> productList = productRepository.findByPriceGreaterThanEqual(q);
        hm.put(ERest.total, productRepository.countAllBy());
        hm.put(ERest.searchTotal, productList.size());
        hm.put(ERest.status, true);
        hm.put(ERest.result, productList);
        return new ResponseEntity(hm, HttpStatus.OK);
    }




}
