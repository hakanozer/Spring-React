package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.services.ProductServices;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    final ProductServices pService;

    public ProductRestController(ProductServices pService) {

        this.pService = pService;
    }

    @PostMapping("/ekle")
    public ResponseEntity ekle (@RequestBody Product product){

        return pService.ekle(product);
    }
    @DeleteMapping("/sil")
    public ResponseEntity sil(Product product){

        return pService.sil(product);
    }
    @PutMapping("/update")
    public ResponseEntity update (@RequestBody Product product){

        return pService.update(product);
    }
    @GetMapping("/list")
    public ResponseEntity list (){

        return pService.list();
    }
    @GetMapping("/search")
    public ResponseEntity search (String q){

        return pService.search(q);
    }
    @GetMapping("/priceSearch")
    public ResponseEntity priceSearch (Double p){

        return pService.priceSearch(p);
    }
}
