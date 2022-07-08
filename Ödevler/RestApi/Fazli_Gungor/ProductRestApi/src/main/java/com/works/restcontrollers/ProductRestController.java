package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.services.ProductService;
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
    public ResponseEntity save(@RequestBody Product product) {
        return productService.save(product);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam String id) {
        return productService.delete(id);
    }


    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Product product) {
        return productService.update(product);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return productService.list();
    }

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam String q) {
        return productService.search(q);
    }

    @GetMapping("/pricesearch")
    public ResponseEntity pricesearch(@RequestParam Double q) {
        return productService.pricesearch(q);
    }

}
