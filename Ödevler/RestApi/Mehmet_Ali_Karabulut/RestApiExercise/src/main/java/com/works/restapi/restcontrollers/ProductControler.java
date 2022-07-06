package com.works.restapi.restcontrollers;

import com.works.restapi.entities.Product;
import com.works.restapi.services.ProductService;
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
    public ResponseEntity list() {

        return productService.list();
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam String pid) {
        return productService.delete(pid);
    }

    @GetMapping("/single")
    public ResponseEntity single(@RequestParam String pid) {
        return productService.single(pid);
    }


    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Product product) {
        return productService.update(product);
    }

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam String q) {
        return productService.search(q);
    }

    @GetMapping("/searchByPrice")
    public ResponseEntity searchByPrice(@RequestParam int q) {
        return productService.searchByPrice(q);
    }
}



