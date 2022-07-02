package com.mhk.productmanager.service;

import com.mhk.productmanager.entity.Product;
import java.util.List;
import org.springframework.http.ResponseEntity;

public interface ProductService {

  ResponseEntity<Product> saveProduct(Product product);

  ResponseEntity<List<Product>> getProductList();

  ResponseEntity<List<Product>> findByTitleContainsIgnoreCaseOrDetailsContainsIgnoreCase(String q);

  ResponseEntity<List<Product>> findProductListByPriceGreaterThanEqual(double q);

  ResponseEntity<Product> updateProduct(Product product);

  ResponseEntity deleteProduct(String id);

}
