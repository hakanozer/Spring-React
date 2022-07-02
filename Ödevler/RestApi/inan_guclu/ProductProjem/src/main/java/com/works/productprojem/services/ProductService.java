package com.works.productprojem.services;

import com.works.productprojem.entities.Product;
import com.works.productprojem.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {

    final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public ResponseEntity save(Product product) {
        Map<String, Object> hm = new LinkedHashMap<>();
        Product p = productRepository.save(product);
        hm.put("product", p);
        return new ResponseEntity<>(hm, HttpStatus.OK);
    }


    public ResponseEntity list() {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("products", productRepository.findAll());
        return new ResponseEntity<>(hm, HttpStatus.OK);
    }


    public ResponseEntity delete(String id) {
        Map<String, Object> hm = new LinkedHashMap<>();
        try {
            int iid = Integer.parseInt(id);
            productRepository.deleteById(iid);
            hm.put("success", true);
        } catch (Exception ex) {
            hm.put("message", "id request : " + id);
            hm.put("success", false);
            return new ResponseEntity<>(hm, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(hm, HttpStatus.OK);

    }

    public ResponseEntity single(String sid) {

        Map<String, Object> hm = new LinkedHashMap<>();
        try {
            int id = Integer.parseInt(sid);
            Optional<Product> oProduct = productRepository.findById(id);
            if (oProduct.isPresent()) {
                hm.put("status", true);
                hm.put("result", oProduct.get());
            } else {
                hm.put("status", false);
                hm.put("result", "empty!!");
            }

        } catch (Exception ex) {
            hm.put("message", "id request : " + sid);
            hm.put("success", false);
            return new ResponseEntity<>(hm, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(hm, HttpStatus.OK);

    }

    public ResponseEntity update(Product product){
        Map<String,Object> hm =new LinkedHashMap<>();
        Optional<Product> oProduct=productRepository.findById(product.getProductID());
        if (oProduct.isPresent()){
            productRepository.saveAndFlush(product);
            hm.put("message", product);
            hm.put("status", true);
        }else {
            hm.put("message","fail uid");
            hm.put("status", false);
        }




        return new ResponseEntity(hm,HttpStatus.OK);
    }

}
