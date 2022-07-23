package com.works.productrestapihomework.restcontrollers;

import com.works.productrestapihomework.entities.Product;
import com.works.productrestapihomework.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    final ProductService productService;
    public ProductRestController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product product){
        return productService.save(product);
    }

    @GetMapping("/list")
    public ResponseEntity list(){
        return productService.list();
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam String sid){
        return productService.delete(sid);
    }

    @GetMapping("/single")
    public ResponseEntity single(@RequestParam String sid){
        return productService.single(sid);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Product product){
        return productService.update(product);
    }
    @GetMapping("/search")
    public ResponseEntity search (@RequestParam String q){
        return productService.search(q);
    }

    @GetMapping("/searchByPrice")
    public ResponseEntity searchByPrice(@RequestParam int q){
        return productService.searchByPrice(q);
    }
}
