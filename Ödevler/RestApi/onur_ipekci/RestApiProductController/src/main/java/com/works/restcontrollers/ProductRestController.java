package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/product")
@Validated
public class ProductRestController {

    final ProductService pService;
    public ProductRestController(ProductService pService) {
        this.pService = pService;
    }


    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product product) {
        return pService.save(product);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return pService.list();
    }
    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam String id) {
        return pService.delete(id);
    }

    @PutMapping ("/update")
    public ResponseEntity update(@RequestBody Product product) {
        return pService.update(product);
    }

    @GetMapping ("/search")
    public ResponseEntity search(@RequestParam String q) {
        return pService.search(q);
    }

    @GetMapping ("/priceSearch")
    public ResponseEntity search(@RequestParam int p) {
        return pService.priceSearch(p);
    }
}
