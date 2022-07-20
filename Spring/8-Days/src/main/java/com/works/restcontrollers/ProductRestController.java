package com.works.restcontrollers;

import com.works.entities.Product;
import com.works.services.ProductService;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
public class ProductRestController {

    final ProductService pService;
    final CacheManager cacheManager;
    public ProductRestController(ProductService pService, CacheManager cacheManager) {
        this.pService = pService;
        this.cacheManager = cacheManager;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product product) {
        cacheManager.getCache("productList").clear();
        return pService.save( product );
    }

    @GetMapping("/list")
    @Cacheable("productList")
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


    @Scheduled(fixedDelay = 5000)
    public void resetCache() {
        cacheManager.getCache("productList").clear();
        System.out.println("ResetCache Call");
    }

}
