package com.app.cart.service;

import org.springframework.http.ResponseEntity;
import com.app.cart.entity.Product;

/**
 * @author Priyanka Bagul
 * @since 05-Feb-2018
 */

public interface ProductService {

    public ResponseEntity<?> addProduct(Product product);

    public ResponseEntity<?> editProduct(Integer id, Product product);

    public ResponseEntity<?> deleteProduct(Integer id);

    public ResponseEntity<?> getProduct(Integer id);

    public ResponseEntity<?> getAllProducts();

    public ResponseEntity<?> getProductByCategory(Integer id);

    public ResponseEntity<?> getProductByBrand(Integer id);

}
