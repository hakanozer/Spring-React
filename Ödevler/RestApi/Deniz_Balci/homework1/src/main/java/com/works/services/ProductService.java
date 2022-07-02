package com.works.services;

import com.works.entities.Product;
import com.works.repository.ProductRepository;
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

    public ResponseEntity save (Product product){
        Map<String, Object> hm = new LinkedHashMap<>();
        if (product.getPrice() < 10 ){
            hm.put("status:",false);
            hm.put("result:","Price must be at least 10");
        } else if (product.getTitle().length() <4 || product.getTitle().length() >40 ) {
            hm.put("status:",false);
            hm.put("result:","Title must be between 4 and 40 characters");
        }else {
            pRepo.save(product);
            hm.put("status:",true);
            hm.put("result:",product);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity delete (String pid){
        Map<String, Object> hm = new LinkedHashMap<>();
        try {
            int id = Integer.parseInt(pid);
            Optional<Product> oUser = pRepo.findById(id);
            if (oUser.isPresent()){
                pRepo.deleteById(id);
                hm.put("status", true);
                hm.put("message", pid+" no'lu kullanıcı silindi");
            }else {
                hm.put("message", "Kullanıcı Bulunamadı");
                hm.put("status", false);
            }
        }catch (Exception ex) {
            hm.put("message", "request id: "+pid+" sayısal olmalı");
            hm.put("status",false);
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity update (Product product){
        Map<String, Object> hm = new LinkedHashMap<>();
        if (pRepo.findByPidEquals(product.getPid()).isPresent()){
            pRepo.saveAndFlush(product);
            hm.put("message", product);
            hm.put("status", true);
        }else{
            hm.put("message", "Ürün Bulunamadı");
            hm.put("status", false);
        }
        return new ResponseEntity(hm,HttpStatus.OK);
    }

    public ResponseEntity list () {
        Map<String, Object> hm = new HashMap<>();
        hm.put("users", pRepo.findAll());

        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity search (String q){
        Map<String, Object> hm = new LinkedHashMap<>();
        List<Product> ls = pRepo.findByTitleContainsIgnoreCaseAndDetailContainsIgnoreCase(q,q);
        if (ls.isEmpty()){
            hm.put("status", false);
            hm.put("message", "Kullanıcı Bulunamadı");
        }else{
            hm.put("total",pRepo.countAllBy());
            hm.put("searchTotal", ls.size());
            hm.put("status", true);
            hm.put("users", ls);
        }

        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity searchPrice (String p){
        Map<String, Object> hm = new LinkedHashMap<>();
        int pp = Integer.parseInt(p);
        List<Product> ls = pRepo.findByPriceGreaterThanEqual(pp);
        if (ls.isEmpty()){
            hm.put("status", false);
            hm.put("message", "Fiyatı "+p+"'den büyük olan ürün bulunamadı");
        }else{
            hm.put("total",pRepo.countAllBy());
            hm.put("searchTotal", ls.size());
            hm.put("status", true);
            hm.put("message", "Fiyatı "+p+"'den büyük olan ürünler");
            hm.put("users", ls);
        }

        return new ResponseEntity(hm, HttpStatus.OK);
    }
}
