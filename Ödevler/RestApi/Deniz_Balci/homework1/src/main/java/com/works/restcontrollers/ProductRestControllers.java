package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/product")
public class ProductRestControllers {

    final ProductService pService;

    public ProductRestControllers(ProductService pService) {
        this.pService = pService;
    }

    @PostMapping("/save")
    public ResponseEntity save (@RequestBody Product product){
        return pService.save(product);
    }

    @DeleteMapping("/delete")
    public ResponseEntity delete ( @RequestParam String pid){
        return pService.delete(pid);
    }

    @PutMapping("/update")
    public ResponseEntity update (@RequestBody Product product){
        return pService.update(product);
    }

    @GetMapping ("/list")
    public ResponseEntity list (){
        return pService.list();
    }

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam String q){
        return pService.search(q);
    }

    @GetMapping("/searchprice")
    public ResponseEntity searchPrice (@RequestParam String p){
        return pService.searchPrice(p);
    }
}
