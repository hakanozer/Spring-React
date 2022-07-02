package com.denizkaplan.iea.controller;


import com.denizkaplan.iea.entitiy.Product;
import com.denizkaplan.iea.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping()
    public ResponseEntity getAllProducts(){
      return productService.getAllProducts();
    }

    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody Product product) {
        return productService.save(product);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateProductById(@PathVariable Long id,@Valid @RequestBody Product product){
            return  productService.updateProductById(id,product);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id){
        return  productService.deleteById(id);
    }

    @GetMapping("/search")
    public ResponseEntity search( @RequestParam String q ) {
        return productService.search(q);
    }

    @GetMapping("/searchPrice")
    public ResponseEntity searchPrice(@RequestParam int price){
        return productService.searchPrice(price);
    }
}
