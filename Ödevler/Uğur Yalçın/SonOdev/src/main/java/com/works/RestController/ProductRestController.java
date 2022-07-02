package com.works.RestController;


import com.works.Services.ProductService;
import com.works.entities.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    final ProductService pService;
    public ProductRestController(ProductService pService) {
        this.pService = pService;
    }


    @GetMapping("/search")
    public ResponseEntity search( @RequestParam String q ) {
        return pService.search(q);
    }


    @GetMapping("/list")
    public ResponseEntity list() {
        return pService.list();
    }


    @DeleteMapping("/delete")
    public ResponseEntity delete( @RequestParam String id ) {
        return pService.delete(id);
    }


    @PutMapping("/update")
    public ResponseEntity update( @RequestBody Product product ) {
        return pService.update(product);
    }


    @PostMapping("/save")
    public ResponseEntity save( @RequestBody Product product ) {
        return pService.save(product);
    }

}
