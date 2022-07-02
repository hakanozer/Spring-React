package com.works.RestApi.restcontrollers;

import com.works.RestApi.entities.Product;
import com.works.RestApi.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/Product")
public class ProductControler {

    final ProductService productService;

    public ProductControler(ProductService productService) {
        this.productService = productService;
    }
    //save
    @PostMapping("/save")
    public ResponseEntity save (@RequestBody Product product){

        return productService.save(product);
    }
    //list
    @GetMapping("/list")
    public ResponseEntity list(){

        return productService.list();
    }
    //Delete
    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam String pid){
       return productService.delete(pid);
    }

   // Aranan data
    @GetMapping("/single")
    public ResponseEntity single (@RequestParam String pid){
        return productService.single(pid);
    }

    //update
    @PutMapping("/update")
    public ResponseEntity update (@RequestBody Product product){
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



