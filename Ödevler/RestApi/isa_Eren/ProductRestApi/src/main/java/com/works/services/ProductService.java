package com.works.services;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import com.works.utilities.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {
    final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity save(Product product) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        productRepository.save(product);
        hm.put(ERest.RESULT, product);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity delete(String sid) {
        Map<ERest, Object> hm = new HashMap<>();
        try {
            int iid = Integer.parseInt(sid);
            productRepository.deleteById(iid);
            hm.put(ERest.STATUS, true);
        } catch (Exception ex) {
            hm.put(ERest.MESSAGE, "id request : " + sid);
            hm.put(ERest.STATUS, false);
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }
//

    public ResponseEntity update(Product product) {
        Map<ERest, Object> hm = new HashMap<>();
        Optional<Product> oProduct = productRepository.findById(product.getPid());
        if (oProduct.isPresent()) {
            productRepository.saveAndFlush(product);
            hm.put(ERest.RESULT, product);
            hm.put(ERest.STATUS, true);
        } else {
            hm.put(ERest.MESSAGE, "Fail uid");
            hm.put(ERest.STATUS, false);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list() {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.RESULT, productRepository.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity search(String q) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        List<Product> ls = productRepository.findByTitleContainsIgnoreCaseOrDetailContainsIgnoreCase(q, q);
        hm.put(ERest.STATUS, true);
        hm.put(ERest.RESULT, ls);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity pricesearch(double q) {
        //fiyatı eşit yada büyük olanlar getir
        Map<ERest, Object> hm = new LinkedHashMap<>();
        List<Product> ls = productRepository.findByPriceGreaterThanEqual(q);
        hm.put(ERest.STATUS, true);
        hm.put(ERest.RESULT, ls);
        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
