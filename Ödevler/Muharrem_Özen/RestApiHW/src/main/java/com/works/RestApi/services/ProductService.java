package com.works.RestApi.services;

import com.works.RestApi.entities.Product;
import com.works.RestApi.repositories.ProductRepository;
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

    public ResponseEntity save ( Product product){
        Map<String,Object> hm = new HashMap<>();
        Product u = pRepo.save(product);
        hm.put("product",u);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list(){
        Map<String,Object> hm = new HashMap<>();
        hm.put("products",pRepo.findAll());
        return new ResponseEntity(hm,HttpStatus.OK);
    }

    public ResponseEntity delete( String pid){
        Map<String,Object> hm =new HashMap<>();
        try {
            int iid = Integer.parseInt(pid);
            pRepo.deleteById(iid);
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
            Optional<Product> optionalProduct = pRepo.findById(id);
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
    public ResponseEntity search( String q) {
        Map<String, Object> hm = new LinkedHashMap<>();
        List<Product> ls = pRepo.findByTitleContainsIgnoreCaseOrDetailContainsIgnoreCase(q,q);
        hm.put("total", pRepo.countAllBy());
        hm.put("searchTotal", ls.size() );
        hm.put("status", true);
        hm.put("users", ls);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity searchByPrice( int q) {
        Map<String, Object> hm = new LinkedHashMap<>();
        List<Product> ls = pRepo.findByPriceGreaterThanEqual(q);
        hm.put("total", pRepo.countAllBy());
        hm.put("searchTotal", ls.size() );
        hm.put("status", true);
        hm.put("users", ls);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

}







