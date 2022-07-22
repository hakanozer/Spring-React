package com.example.restapiproductcontroller.services;


import com.example.restapiproductcontroller.entities.Product;
import com.example.restapiproductcontroller.repositories.ProductRepository;
import com.example.restapiproductcontroller.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    final ProductRepository uRepo;


    public ProductService(ProductRepository uRepo) {
        this.uRepo = uRepo;
    }

    public ResponseEntity save(Product product){
        Map<ERest, Object> hm = new LinkedHashMap<>();

        uRepo.save(product);
        hm.put(ERest.result, product);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity delete(String pid){
        Map<ERest, Object> hm = new LinkedHashMap<>();
       try{
           int nid =Integer.parseInt(pid);
           uRepo.deleteById(nid);
           hm.put(ERest.status, true );
       }catch (Exception ex){
           hm.put(ERest.message, "id request" + pid);
           hm.put(ERest.status,false);

           return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
       }
       return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity update (Product product){
        Map<String,Object> hm = new HashMap<>();
        Optional<Product> optionalProduct = uRepo.findById(product.getPid());

        if (optionalProduct.isPresent()){
            uRepo.saveAndFlush(product);
            hm.put("message",product);
            hm.put("status",true);

        }
        else {
            hm.put("message","Fail pid");
            hm.put("status",false);
        }
        return new ResponseEntity(hm,HttpStatus.OK);

    }




    public ResponseEntity list() {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.result, uRepo.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }




    public ResponseEntity searchArananData (String q){
        Map<String,Object> hm = new HashMap<>();
        try{
            int id = Integer.parseInt(q);
            Optional<Product> optionalProduct = uRepo.findById(id);
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


    public ResponseEntity searchTitleDetail( String q) {
        Map<String, Object> hm = new LinkedHashMap<>();
        List<Product> ls = uRepo.findByTitleContainsIgnoreCaseOrDetailContainsIgnoreCase(q,q);
        hm.put("total", uRepo.countAllBy());
        hm.put("searchTotal", ls.size() );
        hm.put("status", true);
        hm.put("users", ls);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity searchByPrice( double q) {
        Map<String, Object> hm = new LinkedHashMap<>();
        List<Product> ls = uRepo.findByPriceGreaterThanEqual(q);
        hm.put("total", uRepo.countAllBy());
        hm.put("searchTotal", ls.size() );
        hm.put("status", true);
        hm.put("users", ls);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
