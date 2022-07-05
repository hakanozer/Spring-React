package com.works.productprojem.restcontrollers;

import com.works.productprojem.entities.Product;
import com.works.productprojem.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    final ProductService productService;

    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product product) {

        return productService.save(product);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return productService.list();

    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam String id) {

        return productService.delete(id);
    }

    @GetMapping("/single")
    public ResponseEntity single(@RequestParam String id){
        return productService.single(id);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Product product){
        return  productService.update(product);
    }

}
