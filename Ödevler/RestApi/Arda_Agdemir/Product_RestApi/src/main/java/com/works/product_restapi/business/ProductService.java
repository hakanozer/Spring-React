package com.works.product_restapi.business;

import com.works.product_restapi.entities.Product;
import com.works.product_restapi.repositories.ProductRepository;
import com.works.product_restapi.utilities.ERest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static com.works.product_restapi.utilities.ERest.*;

@Service
public class ProductService {

    final ProductRepository productRepository;
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ResponseEntity save(Product product){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        productRepository.save(product);
        hm.put(status,true);
        hm.put(result, product);

        return new ResponseEntity(hm, HttpStatus.OK);
    }

    public ResponseEntity delete(String id){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        try {
            int iid = Integer.parseInt(id);
            productRepository.deleteById(iid);
            hm.put(status, true);
            hm.put(message, "Success Deleted");
        }catch (Exception ex){
            hm.put(message, "Id not found");
            hm.put(status, false);
            return new ResponseEntity<>(hm, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(hm, HttpStatus.OK);
    }

    public ResponseEntity update(Product product){
        Map<ERest, Object> hm = new LinkedHashMap<>();

        Optional<Product> optionalProduct = productRepository.findById(product.getPid());
        if (optionalProduct.isPresent()){
            productRepository.saveAndFlush(product);
            hm.put(message, product);
            hm.put(status, true);
        }
        else {
            hm.put(message, "Invalid Value");
            hm.put(status, false);
        }
        return new ResponseEntity<>(hm, HttpStatus.OK);
    }

    public ResponseEntity list(){
        Map<ERest,Object> hm = new LinkedHashMap<>();
        List<Product> ls = productRepository.findAll();
        hm.put(status, true);
        hm.put(result, ls);

        return new ResponseEntity<>(hm, HttpStatus.OK);
    }

    public ResponseEntity search(String q){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        List<Product> ls = productRepository.findByTitleContainsIgnoreCaseOrDetailContainsIgnoreCase(q,q);

        hm.put(status, false);
        hm.put(message, "Invalid Value");
        for (Product item : ls){
            if (item.getDetail().contains(q) || item.getTitle().contains(q)){
                hm.put(status, true);
                hm.put(result, ls);
            }
        }
        return new ResponseEntity<>(hm, HttpStatus.OK);
    }

    public ResponseEntity priceSearch(int p){
        Map<ERest, Object> hm = new LinkedHashMap<>();
        List<Product> ls = productRepository.findByPriceGreaterThanEqual(p);

        hm.put(status, false);
        hm.put(result, "A value greater than the entered value was not found.");
        for (Product item : ls){
            if (p <= item.getPrice()){
                hm.put(status, true);
                hm.put(result, ls);
            }
        }
        return new ResponseEntity<>(hm, HttpStatus.OK);
    }
}
