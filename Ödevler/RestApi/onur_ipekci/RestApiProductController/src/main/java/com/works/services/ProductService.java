package com.works.services;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class ProductService {

    final ProductRepository pRepo;
    public ProductService(ProductRepository pRepo) {
        this.pRepo = pRepo;
    }


    public ResponseEntity save( Product product) {
        Map<String, Object> hm = new HashMap<>();
        pRepo.save(product);
        hm.put("product", product);
        return new ResponseEntity<>(hm, HttpStatus.OK);
    }
    public ResponseEntity list() {
        Map<String, Object> hm = new HashMap<>();
        hm.put("product", pRepo.findAll());
        return new ResponseEntity<>(hm, HttpStatus.OK);
    }
    public ResponseEntity delete( String id) {
        Map<String, Object> hm = new HashMap<>();
        try {
            int iid = Integer.parseInt(id);
            pRepo.deleteById(iid);
            hm.put("status",true);
        }catch (Exception ex){
            hm.put("message","pid reques :"+id);
            hm.put("status",false);
            return new ResponseEntity(hm,HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(hm, HttpStatus.OK);
    }

    public ResponseEntity update(Product product){
        Map<String, Object> hm = new HashMap<>();
        Optional<Product> oProduct = pRepo.findById(product.getPid());
        if (oProduct.isPresent()){
            pRepo.saveAndFlush(product);
            hm.put("message",product);
            hm.put("status",true);
        }else {
            hm.put("message","fail pid");
            hm.put("status",false);
        }
        return new ResponseEntity<>(hm, HttpStatus.OK);
    }

    public ResponseEntity search(String q){
        Map<String, Object> hm = new HashMap<>();
        List<Product> ls = pRepo.findByTitleLikeIgnoreCaseOrDetailLikeIgnoreCase(q,q);
        hm.put("status",true);
        hm.put("product",ls);
        return new ResponseEntity<>(hm, HttpStatus.OK);
    }

    public ResponseEntity priceSearch(int p){
        Map<String, Object> hm = new HashMap<>();
        List<Product> ls = pRepo.findByPriceGreaterThanEqual(p);
        hm.put("status",true);
        hm.put("product",ls);
        return new ResponseEntity<>(hm, HttpStatus.OK);
    }
}
