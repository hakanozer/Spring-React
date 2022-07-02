package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Product")
public class ProductController {

    final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product product){
        return productService.save(product);
    }
}
