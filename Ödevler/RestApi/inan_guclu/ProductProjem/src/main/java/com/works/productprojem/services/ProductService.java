package com.works.productprojem.services;

import com.works.productprojem.entities.Product;
import com.works.productprojem.repositories.ProductRepository;
import com.works.productprojem.utils.ERest;
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
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
            int iid = Integer.parseInt(id);
            productRepository.deleteById(iid);
            hm.put(ERest.status, true);
        } catch (Exception ex) {
            hm.put(ERest.message, "id request : " + id);
            hm.put(ERest.status, false);
            return new ResponseEntity<>(hm, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(hm, HttpStatus.OK);

    }

    public ResponseEntity single(String sid) {

        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
            int id = Integer.parseInt(sid);
            Optional<Product> oProduct = productRepository.findById(id);
            if (oProduct.isPresent()) {
                hm.put(ERest.status, true);
                hm.put(ERest.result, oProduct.get());
            } else {
                hm.put(ERest.status, false);
                hm.put(ERest.message, "empty!!");
            }

        } catch (Exception ex) {
            hm.put(ERest.message, "id request : " + sid);
            hm.put(ERest.status, false);
            return new ResponseEntity<>(hm, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity(hm, HttpStatus.OK);

    }

    public ResponseEntity update(Product product) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Optional<Product> oProduct = productRepository.findById(product.getProductID());
        if (oProduct.isPresent()) {
            productRepository.saveAndFlush(product);
            hm.put(ERest.message, product);
            hm.put(ERest.status, true);
        } else {
            hm.put(ERest.message, "fail uid");
            hm.put(ERest.status, false);
        }


        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity search(String q){
        Map<ERest,Object>hm=new LinkedHashMap<>();
        List<Product> ls= productRepository.findByTitleContainsIgnoreCaseOrDetailContainsIgnoreCase(q,q);
        hm.put(ERest.result,ls);
        return new ResponseEntity(hm,HttpStatus.OK);
    }

    public ResponseEntity pricesearch(Integer q){
        Map<ERest,Object>hm=new LinkedHashMap<>();
        List<Product> ls= productRepository.findByPriceGreaterThanEqual(q);

        hm.put(ERest.status,true);
        hm.put(ERest.result,ls);
        return new ResponseEntity<>(hm,HttpStatus.OK);

    }



}
