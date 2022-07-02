package com.works.product_restapi.controllers;


import com.works.product_restapi.business.ProductService;
import com.works.product_restapi.entities.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping("/product")
public class ProductController {

    ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam String id){
        return productService.delete(id);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Product product){
        return productService.update(product);
    }

    @GetMapping("/list")
    public ResponseEntity list(){
        return productService.list();
    }

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam String q){
        return productService.search(q);
    }

    @GetMapping("/priceSearch")
    public ResponseEntity priceSearch(@RequestParam Integer p){
        return productService.priceSearch(p);
    }
}