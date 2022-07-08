package com.example.restapiproductcontroller.restcontrollers;

import com.example.restapiproductcontroller.entities.Product;
import com.example.restapiproductcontroller.services.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/product")
public class ProductServiceRestControllers {
    final ProductService pService;


    public ProductServiceRestControllers(ProductService pService)
    {

        this.pService = pService;
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody Product product){
        return pService.save(product);

    }
    @GetMapping("/list")
    public ResponseEntity list() {

        return pService.list();
    }


    @DeleteMapping("/delete")
    public ResponseEntity delete(@RequestParam String pid){
        return pService.delete(pid);
    }

    @GetMapping("/searchArananData")
    public ResponseEntity searchArananData(@RequestParam String pid){
        return pService.searchArananData(pid);
    }

    @GetMapping("/searchTitleDetail")
    public ResponseEntity search(@RequestParam String q) {
        return pService.searchTitleDetail(q);
    }

    @GetMapping("/searchByPrice")
    public ResponseEntity searchByPrice(@RequestParam int q) {
        return pService.searchByPrice(q);
    }
    @PutMapping("/update")
    public ResponseEntity update (@RequestBody Product product){
        return pService.update(product);
    }




}
