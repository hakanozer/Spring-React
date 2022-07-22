package com.example.product.Services;

import com.example.product.Entities.Product;
import com.example.product.Repositories.ProductRepository;
import com.example.product.utils.ERest;
import net.bytebuddy.pool.TypePool;
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
        Map<ERest, Object> hm = new LinkedHashMap<>();


        productRepository.save(product);
        hm.put(ERest.status, true);
        hm.put(ERest.result, product);


        return new ResponseEntity(hm, HttpStatus.OK);

    }


    public ResponseEntity list(Product product){
        Map<String,Object> hm=new LinkedHashMap<>();
        return new ResponseEntity(hm, HttpStatus.OK);
    }
    public ResponseEntity delete(String id) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
            int idd = Integer.parseInt(id);
            productRepository.deleteById(idd);
            hm.put(ERest.status, true);

        } catch (Exception e) {
            hm.put(ERest.message, " id hatalı" + id);
            hm.put(ERest.status, false);

        }
        return new ResponseEntity<>(hm, HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity single(String sid){
        Map<ERest,Object> hm=new LinkedHashMap<>();
        try {
            int id = Integer.parseInt(sid);
            Optional<Product> oProduct=productRepository.findById(id);
            if (oProduct.isPresent()){
                hm.put(ERest.status,true);
                hm.put(ERest.result,oProduct.get());
            }else
                hm.put(ERest.status,false);
                hm.put(ERest.message, "empty");

        } catch (Exception e) {
            hm.put(ERest.message, " id hatalı" + sid);
            hm.put(ERest.status, false);
            return new ResponseEntity<>(hm,HttpStatus.BAD_REQUEST);

        }
        return new ResponseEntity(hm,HttpStatus.OK);
    }
    public ResponseEntity update(Product product){
        Map<ERest,Object> hm=new LinkedHashMap<>();
        Optional<Product> oProduct=productRepository.findById(product.getProductID());
        if (oProduct.isPresent()){
            productRepository.saveAndFlush(product);
            hm.put(ERest.message,product);
            hm.put(ERest.status,true);
        }else {
            hm.put(ERest.message,"fail");
            hm.put(ERest.status,false);
        }
        return new ResponseEntity(hm,HttpStatus.OK);
    }
    public ResponseEntity search(String sorgu){
        Map<ERest,Object>hm=new LinkedHashMap<>();
        List<Product> ls= productRepository.findByTitleContainsIgnoreCaseOrDetailContainsIgnoreCase(sorgu,sorgu);
        hm.put(ERest.result,ls);
        return new ResponseEntity(hm,HttpStatus.OK);
    }

    public ResponseEntity pricesearch(Integer sorgu){
        Map<ERest,Object>hm=new LinkedHashMap<>();
        List<Product> ls= productRepository.findByPriceGreaterThanEqual(sorgu);

        hm.put(ERest.status,true);
        hm.put(ERest.result,ls);
        return new ResponseEntity<>(hm,HttpStatus.OK);

    }
}









