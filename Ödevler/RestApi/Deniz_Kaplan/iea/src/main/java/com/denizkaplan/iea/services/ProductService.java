package com.denizkaplan.iea.services;

import com.denizkaplan.iea.entitiy.Product;
import com.denizkaplan.iea.repository.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity getAllProducts() {
        Map<String, Object> hm = new LinkedHashMap<>();

        hm.put("status", true);
        hm.put("result", productRepository.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity save(Product product) {
        Map<String, Object> hm = new LinkedHashMap<>();
        System.out.println(product);
        productRepository.save(product);
        hm.put("status", true);
        hm.put("result", product);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity updateProductById(Long id, Product product) {
        Map<String, Object> hm = new LinkedHashMap<>();
        Optional<Product> uproduct=productRepository.findById(id);
        if(uproduct.isPresent()){
            uproduct.get().setDetail(product.getDetail());
            uproduct.get().setTitle(product.getTitle());
            uproduct.get().setPrice(product.getPrice());
            productRepository.save(uproduct.get());
            hm.put("status", true);
        }else {
            hm.put("status", false);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity deleteById(Long id) {
        Map<String, Object> hm = new LinkedHashMap<>();
        productRepository.deleteById(id);
        hm.put("status", true);
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity search(String q) {
        Map<String, Object> hm = new LinkedHashMap<>();
        List<Product> ls = productRepository.findByTitleContainsIgnoreCaseOrDetailContainsIgnoreCase(q,q);
        hm.put("searchTotal", ls.size() );
        hm.put("status", true);
        hm.put("users", ls);

        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity searchPrice(int price) {
        Map<String, Object> hm = new LinkedHashMap<>();
        List<Product> ls = productRepository.findByPriceIsGreaterThanEqual(price);
        hm.put("searchTotal", ls.size() );
        hm.put("status", true);
        hm.put("users", ls);

        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
