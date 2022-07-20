package com.works.services;

import com.works.entities.Product;
import com.works.repositories.JoinProCatRepository;
import com.works.repositories.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class ProductService {

    final ProductRepository pRepo;
    final JoinProCatRepository jRepo;
    public ProductService(ProductRepository pRepo, JoinProCatRepository jRepo) {
        this.pRepo = pRepo;
        this.jRepo = jRepo;
    }

    public ResponseEntity save(Product product) {
        Map<String, Object> hm = new LinkedHashMap<>();
        pRepo.save( product );
        hm.put("status", true);
        hm.put("result", product);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list() {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        hm.put("result", jRepo.allProduct() );
        return new ResponseEntity(hm, HttpStatus.OK);
    }


    public ResponseEntity search( String q ) {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        hm.put("result", jRepo.searchProduct( "%" + q + "%" ));
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity pageProduct( int start, int count ) {
        Map<String, Object> hm = new LinkedHashMap<>();
        if ( count > 5 ) {
            count = 5;
        }
        hm.put("status", true);
        hm.put("total", jRepo.totalSize());
        hm.put("result", jRepo.pageProduct(start * count, count));
        return new ResponseEntity(hm, HttpStatus.OK);
    }



    public ResponseEntity searchPage( String q, int page, int size ) {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        if ( size > 5 ) {
            size = 5;
        }
        Pageable pageable = PageRequest.of(page, size, Sort.by("price").ascending() );
        hm.put("total", jRepo.countTotal("%" + q + "%"));
        hm.put("result", jRepo.findAllPage("%" + q + "%" ,pageable) );
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity allProCatID( int cid ) {
        Map<String, Object> hm = new LinkedHashMap<>();
        hm.put("status", true);
        hm.put("result", pRepo.allProCatID( cid ) );
        return new ResponseEntity(hm, HttpStatus.OK);
    }

}
