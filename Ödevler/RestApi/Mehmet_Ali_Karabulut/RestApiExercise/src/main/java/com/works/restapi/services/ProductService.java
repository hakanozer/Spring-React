package com.works.restapi.services;

import com.works.restapi.entities.Product;
import com.works.restapi.repositories.ProductRepository;
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

    public ResponseEntity save ( Product product){
        Map<String,Object> hm = new HashMap<>();
        Product p = productRepository.save(product);
        hm.put("product",p);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list(){
        Map<String,Object> hm = new HashMap<>();
        hm.put("products", productRepository.findAll());
        return new ResponseEntity(hm,HttpStatus.OK);
    }

    public ResponseEntity delete( String pid){
        Map<String,Object> hm =new HashMap<>();

        try {
            int iid = Integer.parseInt(pid);
            productRepository.deleteById(iid);
            hm.put("status",true);
        }catch (Exception ex){
            hm.put("message","id request"+ pid);
            hm.put("status",false);
            return new ResponseEntity(hm,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(hm,HttpStatus.OK);
    }

    public ResponseEntity single (String q){
        Map<String,Object> hm = new HashMap<>();

        try{
            int id = Integer.parseInt(q);
            Optional<Product> optionalProduct = productRepository.findById(id);
            if (optionalProduct.isPresent()){
                hm.put("status",true);
                hm.put("result",optionalProduct.get());
            }else {
                hm.put("status",false);
                hm.put("result","Empty!");
            }
        }catch (Exception ex){
            hm.put("message","id request :" + q);
            hm.put("status",false);
            return new ResponseEntity(hm,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(hm,HttpStatus.OK);

    }

    public ResponseEntity update (Product product){
        Map<String,Object> hm = new HashMap<>();
        Optional<Product> optionalProduct = productRepository.findById(product.getPid());

        if (optionalProduct.isPresent()){
            productRepository.saveAndFlush(product);
            hm.put("message",product);
            hm.put("status",true);
        }
        else {
            hm.put("message","Fail pid");
            hm.put("status",false);
        }
        return new ResponseEntity(hm,HttpStatus.OK);

    }
    public ResponseEntity search( String q) {
        Map<String, Object> hm = new LinkedHashMap<>();
        List<Product> ls = productRepository.findByTitleContainsIgnoreCaseOrDetailContainsIgnoreCase(q,q);
        hm.put("total", productRepository.countAllBy());
        hm.put("searchTotal", ls.size() );
        hm.put("status", true);
        hm.put("users", ls);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity searchByPrice( int q) {
        Map<String, Object> hm = new LinkedHashMap<>();
        List<Product> ls = productRepository.findByPriceGreaterThanEqual(q);
        hm.put("total", productRepository.countAllBy());
        hm.put("searchTotal", ls.size() );
        hm.put("status", true);
        hm.put("users", ls);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

}







