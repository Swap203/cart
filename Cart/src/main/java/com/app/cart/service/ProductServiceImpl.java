package com.app.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.cart.entity.Product;
import com.app.cart.repository.ProductRepository;

/**
 * @author Priyanka Bagul
 * @since 05-Feb-2018
 */

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository repo;

    @Override
    public ResponseEntity<?> addProduct(Product product) {

        try {
            return new ResponseEntity<Integer>(repo.save(product).getProductId(), new HttpHeaders(), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> editProduct(Integer id, Product product) {

        try {
            Product datacopy = repo.findOne(id);
            if (null == datacopy)
                return ResponseEntity.notFound().build();
            product.setProductId(datacopy.getProductId());
            return new ResponseEntity<Product>(repo.save(product), new HttpHeaders(), HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> deleteProduct(Integer id) {

        try {
            Product delObject = repo.findOne(id);
            if (null == delObject)
                return ResponseEntity.notFound().build();
            repo.delete(id);
            return new ResponseEntity<Product>(delObject, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> getProduct(Integer id) {

        try {
            Product reqObject = repo.findOne(id);
            if (null == reqObject)
                return ResponseEntity.notFound().build();
            return new ResponseEntity<Product>(reqObject, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> getAllProducts() {

        try {
            List<Product> productList = repo.findAll();
            if (productList.isEmpty())
                return ResponseEntity.notFound().build();
            return new ResponseEntity<List<Product>>(productList, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> getProductByBrand(Integer id) {
        try {
            List<Product> list = repo.findByBrandBrandId(id);
            if (list.isEmpty())
                return ResponseEntity.notFound().build();
            return new ResponseEntity<List<Product>>(list, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @Override
    public ResponseEntity<?> getProductByCategory(Integer id) {

        try {
            List<Product> list = repo.findByCategoryId(id);
            if (list.isEmpty())
                return ResponseEntity.notFound().build();
            return new ResponseEntity<List<Product>>(list, new HttpHeaders(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

}
