package com.works.restcontrollers;

import com.works.entities.Category;
import com.works.entities.Product;
import com.works.services.CategoryService;
import com.works.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    final ProductService pService;
    public ProductRestController(ProductService pService) {
        this.pService = pService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product product) {
        return pService.save( product );
    }

    @GetMapping("/list")
    public ResponseEntity list() {
        return pService.list();
    }

    @GetMapping("/search")
    public ResponseEntity search( @RequestParam(defaultValue = "") String q ) {
        return pService.search( q );
    }

    @GetMapping("/page")
    public ResponseEntity search( @RequestParam(defaultValue = "0") int start, @RequestParam(defaultValue = "5") int count ) {
        return pService.pageProduct(start, count);
    }

    @GetMapping("/searchpage")
    public ResponseEntity searchpage(@RequestParam(defaultValue = "") String q, @RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "5") int size ) {
        return pService.searchPage(q,page,size);
    }


    @GetMapping("/allProCatID")
    public ResponseEntity allProCatID(@RequestParam(defaultValue = "") int cid ) {
        return pService.allProCatID(cid);
    }

}
