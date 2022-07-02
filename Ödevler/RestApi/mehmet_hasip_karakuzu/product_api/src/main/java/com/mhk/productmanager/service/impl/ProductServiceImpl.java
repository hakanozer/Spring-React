package com.mhk.productmanager.service.impl;

import com.mhk.productmanager.entity.Product;
import com.mhk.productmanager.repository.ProductRepository;
import com.mhk.productmanager.service.ProductService;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

  private final ProductRepository productRepository;

  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }


  @Override
  public ResponseEntity saveProduct(Product product) {

    Map<String, Object> hm = new LinkedHashMap<>();

    productRepository.save(product);

    hm.put("status", true);
    hm.put("savedProduct", product);

    return new ResponseEntity(hm, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<Product>> getProductList() {
    Map<String, Object> hm = new LinkedHashMap<>();
    List<Product> productList = productRepository.findAll();

    hm.put("status", true);
    hm.put("listedProducts", productList);

    return new ResponseEntity(hm, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<Product>> findByTitleContainsIgnoreCaseOrDetailsContainsIgnoreCase(String q) {
    Map<String, Object> hm = new LinkedHashMap<>();
    List<Product> listedProducts = productRepository.findByTitleContainsIgnoreCaseOrDetailsContainsIgnoreCase(
        q, q);

    hm.put("total", productRepository.countAllBy());
    hm.put("searchTotal", listedProducts.size());
    hm.put("status", true);
    hm.put("listedProducts", listedProducts);

    return new ResponseEntity(hm, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<List<Product>> findProductListByPriceGreaterThanEqual(double q) {
    Map<String, Object> hm = new LinkedHashMap<>();
    List<Product> listedProducts = productRepository.findByPriceGreaterThanEqual(q);

    hm.put("totalProducts", productRepository.countAllBy());
    hm.put("searchTotal", listedProducts.size());
    hm.put("status", true);
    hm.put("listedProducts", listedProducts);
    return new ResponseEntity(hm, HttpStatus.OK);
  }

  @Override
  public ResponseEntity<Product> updateProduct(Product product) {
    Map<String, Object> hm = new LinkedHashMap<>();
    Optional<Product> willBeUpdated = productRepository.findById(product.getId());

    if (willBeUpdated.isPresent()) {
      productRepository.saveAndFlush(product);
      hm.put("status", true);
      hm.put("updatedProduct", product);
    } else {
      hm.put("message", "product id is not available in database");
      hm.put("status", false);
    }

    return new ResponseEntity(hm, HttpStatus.OK);
  }

  @Override
  public ResponseEntity deleteProduct(String id) {
    Map<String, Object> hm = new LinkedHashMap<>();

    try {

      Long productId = Long.parseLong(id);
      productRepository.deleteById(productId);
      hm.put("userDeleted", true);

    } catch (Exception e) {
      hm.put("message", "wrong parameter or product id is not available " + id);
      hm.put("userDeleted", false);
      return new ResponseEntity(hm, HttpStatus.BAD_REQUEST);
    }

    return new ResponseEntity(hm, HttpStatus.OK);
  }
}
