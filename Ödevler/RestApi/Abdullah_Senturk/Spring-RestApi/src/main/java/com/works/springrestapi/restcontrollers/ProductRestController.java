package com.works.springrestapi.restcontrollers;

public class ProductRestController {

    final ProductService productService;

    public ProductRestController(ProductService productService) {
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

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Product product) {
        return productService.update(product);
    }

    @GetMapping("/search")
    public ResponseEntity search(@RequestParam String q) {
        return productService.search(q);
    }

    @GetMapping("/priceSearch")
    public ResponseEntity priceSearch(@RequestParam int q) {
        return productService.priceSearch(q);
    }

}
