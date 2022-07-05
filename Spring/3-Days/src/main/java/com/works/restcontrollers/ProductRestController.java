package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@RequestMapping("/product")
@Validated
public class ProductRestController {

    final ProductService pService;
    public ProductRestController(ProductService pService) {
        this.pService = pService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@Valid @RequestBody Product product) {
        return pService.save(product);
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return pService.list();
    }

    @GetMapping("/single/{id}")
    public ResponseEntity single(  @PathVariable @Min(value = 1, message = "id en az 1 olmalıdır.") int id ) {
        return pService.single(id);
    }


}
