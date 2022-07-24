package com.works.Services;

import com.works.Repositories.ProductRepository;
import com.works.entities.Product;
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

    public ResponseEntity list() {
        Map<String, Object> hm = new HashMap<>();
        hm.put("users", pRepo.findAll());
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity search( String q ) {
        Map<String, Object> hm = new LinkedHashMap<>();
        List<Product> ls = pRepo.findByTitleContainsIgnoreCaseOrDetailContainsIgnoreCase(q,q);
        hm.put("total", pRepo.countAllBy());
        hm.put("searchTotal", ls.size() );
        hm.put("status", true);
        hm.put("product", ls);
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity delete( String id ) {
        Map<String, Object> hm = new HashMap<>();
        try {
            int iid = Integer.parseInt(id);
            pRepo.deleteById(iid);
            hm.put("status", true);
        }catch (Exception ex) {
            hm.put("message", "id request : " + id);
            hm.put("status", false);
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity update( Product product ) {
        Map<String, Object> hm = new HashMap<>();
        Optional<Product> pProdcut = pRepo.findById(product.getPid());
        if ( pProdcut.isPresent() ) {
            pRepo.saveAndFlush(product);
            hm.put("message", product);
            hm.put("status", true);
        }else {
            hm.put("message", "Fail pid");
            hm.put("status", false);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity save( Product product) {
        Map<String, Object> hm = new HashMap<>();
        Product p = pRepo.save(product);
        System.out.println( "p :" + p.getClass().hashCode() );
        System.out.println( "product :" + product.getClass().hashCode() );
        hm.put("product", product);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

}