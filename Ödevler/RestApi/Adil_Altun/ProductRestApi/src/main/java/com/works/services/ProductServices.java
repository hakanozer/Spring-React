package com.works.services;

import com.works.entities.Product;
import com.works.repositories.ProductRepository;
import com.works.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductServices {

    final ProductRepository pRepo;

    public ProductServices(ProductRepository pRepo) {
        this.pRepo = pRepo;
    }

    public ResponseEntity ekle (Product product){
        Map<ERest,Object> hm = new LinkedHashMap<>();
        hm.put(ERest.status,true);
        pRepo.save(product);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity sil (Product pid){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
            pRepo.deleteById(pid.getPid());
            hm.put(ERest.status, true );
        }catch (Exception ex){
            hm.put(ERest.status,false);
            hm.put(ERest.messages,"Fail");
        }
        return new ResponseEntity(hm,HttpStatus.OK);
    }

    public ResponseEntity update (Product product){
        Map<String,Object> hm = new LinkedHashMap<>();
        Optional<Product> optionalProduct = pRepo.findById(product.getPid());
        if (optionalProduct.isPresent()){
            pRepo.saveAndFlush(product);
            hm.put("message",product);
            hm.put("status",true);
        }
        else {
            hm.put("message","Fail pid");
            hm.put("status",false);
        }
        return new ResponseEntity(hm,HttpStatus.OK);
    }

    public ResponseEntity list(){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.result, pRepo.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity search(String q) {
        Map<String, Object> hm = new LinkedHashMap<>();
        List<Product> ls = pRepo.findByTitleContainsIgnoreCaseOrDetailContainsIgnoreCase(q,q);
        hm.put("total",pRepo.countAllBy());
        hm.put("status",true);
        hm.put("users",ls);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity priceSearch(Double p){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        List<Product> ls = pRepo.findByPriceGreaterThanEqual(p);
        hm.put(ERest.status,true);
        hm.put(ERest.result,ls);
        return new ResponseEntity(hm,HttpStatus.OK);
    }

}
