package com.works.springrestapi.services;

import com.works.springrestapi.entities.Product;
import com.works.springrestapi.repositories.ProductRepository;
import com.works.springrestapi.utils.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductService {
    final ProductRepository pRepo;

    public ProductService(ProductRepository pRepo) {
        this.pRepo = pRepo;
    }

    public ResponseEntity save( Product product) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        pRepo.save( product );
        hm.put(ERest.status, true);
        hm.put(ERest.result, product);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity list() {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        List<Product> ls = pRepo.findAll();
        hm.put(ERest.status, true);
        hm.put(ERest.result, ls);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity delete( String id ) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
            int iid = Integer.parseInt( id );
            pRepo.deleteById( iid );
            hm.put(ERest.status, true);
            hm.put(ERest.message, "Deletion is successful!");
        } catch (Exception ex) {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Deletion is failed!");
            return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity update( Product product ) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        Optional<Product> oProduct = pRepo.findById(product.getPid());
        if( oProduct.isPresent() ) { // oProduct için varlık denetimi yapıldı
            pRepo.saveAndFlush( product );
            hm.put(ERest.status, true);
            hm.put(ERest.message, product);
        } else {
            hm.put(ERest.status, false);
            hm.put(ERest.message, "Fail pid!");

        }
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity search( String q ) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        List<Product> ls = pRepo.findByTitleEqualsIgnoreCaseOrDetailEqualsIgnoreCase(q,q);
        hm.put(ERest.total, pRepo.countAllBy());
        hm.put(ERest.searchTotal, ls.size());
        hm.put(ERest.status, true);
        hm.put(ERest.result, ls);
        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity priceSearch( int p ) {
        Map<ERest, Object> hm = new LinkedHashMap<>();
        List<Product> ls = pRepo.findByPriceGreaterThanEqual( p );
        hm.put(ERest.total, pRepo.countAllBy());
        hm.put(ERest.priceSearchTotal, ls.size());
        hm.put(ERest.status, true);
        hm.put(ERest.result, ls);
        return new ResponseEntity(hm, HttpStatus.OK);
    }
    
}
