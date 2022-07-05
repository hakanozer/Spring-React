package com.mhk.productmanager.controller;

import com.mhk.productmanager.entity.Product;
import com.mhk.productmanager.service.ProductService;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/product")
public class ProductController {

  private final ProductService productService;


  public ProductController(ProductService productService) {

    this.productService = productService;
  }

  @PostMapping("save")
  ResponseEntity saveProduct(@Valid @RequestBody Product product) {

    return productService.saveProduct(product);
  }

  @GetMapping("getProductList")
  ResponseEntity getProductList() {

    return productService.getProductList();
  }

  @GetMapping("searchProductByTitle")
  ResponseEntity findProductByTitleContaining(@RequestParam String q) {

    return productService.findByTitleContainsIgnoreCaseOrDetailsContainsIgnoreCase(q);
  }

  @GetMapping("searchProductByPrice")
  ResponseEntity findProductByPrice(@RequestParam double q) {

    return productService.findProductListByPriceGreaterThanEqual(q);
  }

  @PutMapping("update")
  ResponseEntity updateProduct(@Valid @RequestBody Product product) {

    return productService.updateProduct(product);
  }

  @DeleteMapping("delete")
  ResponseEntity deleteProduct(String id) {

    return productService.deleteProduct(id);
  }

}
