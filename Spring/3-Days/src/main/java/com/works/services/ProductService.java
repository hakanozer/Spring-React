package com.works.services;

import com.works.entities.Product;
import com.works.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ProductService {

    public List<Product> ls = new ArrayList<>();
    final Random rnd;
    public ProductService(Random randomBeanName) {
        this.rnd = randomBeanName;
    }

    public ResponseEntity save(Product product) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        ls.add(product);
        hm.put(ERest.status, true);
        hm.put(ERest.result, ls);
        return new ResponseEntity( hm, HttpStatus.OK );
    }

    public ResponseEntity list() {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.status, true);
        hm.put(ERest.result, ls);
        return new ResponseEntity( hm, HttpStatus.OK );
    }

    public ResponseEntity single( int id ) {
        System.out.println( rnd.nextInt(100) );
        Map<ERest, Object> hm = new LinkedHashMap<>();
        hm.put(ERest.status, false);
        hm.put(ERest.result, id);
        for ( Product item : ls ) {
            if ( item.getId() == id ) {
                hm.put(ERest.status, true);
                hm.put(ERest.result, item);
                break;
            }
        }
        return new ResponseEntity( hm, HttpStatus.OK );
    }

}
