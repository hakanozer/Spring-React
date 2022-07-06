package com.example.product.controllers;


import com.example.product.Entities.Product;
import com.example.product.Services.ProductService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductControler {

    final ProductService productService;


    public ProductControler(ProductService productService) {
        this.productService = productService;
    }


    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/list")
    public ResponseEntity list(@RequestBody Product product) {
        return productService.list(product);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam String id) {
        return productService.delete(id);
    }

    @GetMapping("/single")
    public ResponseEntity single(@RequestParam String id) {
        return productService.single(id);

    }

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam String q) {
        return productService.search(q);
    }


    @GetMapping("/pricesearch")
    public ResponseEntity pricesearch(@RequestParam Integer p) {
        return productService.pricesearch(p);
    }
}













